# CentOS 7.8.2003部署Kubernetes

## /etc/fstab修改

``` text
UUID=9a1d0da3-6c2d-4196-b224-80cd4e7f75cf swap                    swap    defaults        0 0
```

把原来的```defaults```改为```noauto```，需要重启才能生效。

``` shell
sudo swapoff -a
```

临时关闭交换分区。

## 关闭防火墙

``` shell
sudo systemctl stop firewalld
sudo systemctl disable firewalld
```

## /etc/hosts配置

``` text
151.101.76.133 raw.githubusercontent.com
192.168.122.101 registry
```

```raw.githubusercontent.com```，解决github的文件无法下载。

```registry```，如果有私有仓库，则配置私有的Docker仓库，解决网络下载问题。

## /etc/yum.repos.d/kubernetes.repo源仓库配置

``` text
[kubernetes]
name=Kubernetes
#baseurl=https://packages.cloud.google.com/yum/repos/kubernetes-el7-x86_64
baseurl=https://mirrors.tuna.tsinghua.edu.cn/kubernetes/yum/repos/kubernetes-el7-x86_64
enabled=1
enabled=1
gpgcheck=0
repo_gpgcheck=0
gpgkey=https://packages.cloud.google.com/yum/doc/yum-key.gpg https://packages.cloud.google.com/yum/doc/rpm-package-key.gpg
```

由于google无法访问，配置的是清华大学的镜像。

## Kubernetes相关软件包安装

``` shell
sudo yum install kubelet kubeadm kubectl --disableexcludes=kubernete -y
```

或者指定版本。

``` shell
sudo yum install kubelet-1.19.2-0 kubeadm-1.19.2-0 kubectl-1.19.2-0 --disableexcludes=kubernete -y
```

## Kubelet服务启用

``` shell
sudo systemctl enable --now kubelet
```

## 网络调整

``` shell
echo 1 | sudo tee /proc/sys/net/bridge/bridge-nf-call-iptables
echo 1 | sudo tee /proc/sys/net/bridge/bridge-nf-call-ip6tables
```

## Kubernetes初始化

``` shell
docker login registry:5000
sudo kubeadm init --kubernetes-version 1.19.2 --image-repository registry:5000/google_containers --pod-network-cidr 172.16.0.0/16 --v=5
```

```--kubernetes-version 1.19.2```，指定版本。

```--image-repository registry:5000/google_containers```，镜像仓库位置，这里使用了私有仓库，也可以使用·```registry.aliyuncs.com/google_containers```等其他镜像仓库。

```--pod-network-cidr 172.16.0.0/16```，网段配置，公司网络使用10网段、虚拟机使用192网段，所以这里使用172.16网段，避免冲突。

安装时间取决于镜像拉取速度。

``` text
Your Kubernetes control-plane has initialized successfully!

To start using your cluster, you need to run the following as a regular user:

  mkdir -p $HOME/.kube
  sudo cp -i /etc/kubernetes/admin.conf $HOME/.kube/config
  sudo chown $(id -u):$(id -g) $HOME/.kube/config

You should now deploy a pod network to the cluster.
Run "kubectl apply -f [podnetwork].yaml" with one of the options listed at:
  https://kubernetes.io/docs/concepts/cluster-administration/addons/

Then you can join any number of worker nodes by running the following on each as root:

kubeadm join 192.168.122.171:6443 --token eeo0kp.c2mnza0zfhp7b114 \
    --discovery-token-ca-cert-hash sha256:8c51d54dd79f5d880c6416a307998166b3d0e12df0c8d9a68ff75d003289ab18
```

初始化完成会提示类似上面的信息。主要包含运行```kubectl```需要进行的配置和加入集群的命令。

``` shell
docker images
docker ps
```

可以看到，已经拉取和运行了许多容器。

## Kubectl命令

``` shell
kubectl get pods --all-namespaces
```

查看Pods的状态。有2个coredns处于Pending状态。coredns依赖于[flannel](https://github.com/coreos/flannel/releases)。

``` shell
kubectl describe pod --namespace [NAMESPACE] [NAME]
```

查看Pod的详细情况，可以用于排查问题。

## Flannel安装

``` shell
wget https://github.com/coreos/flannel/releases/download/v0.12.0/flanneld-v0.12.0-amd64.docker
docker load < flanneld-v0.12.0-amd64.docker
```

下载，导入镜像。

``` shell
wget https://raw.githubusercontent.com/coreos/flannel/v0.12.0/Documentation/kube-flannel.yml
sed -i s#10.244.0.0/16#172.16.0.0/16#g kube-flannel.yml
kubectl apply -f kube-flannel.yml
```

使用yaml配置应用Flannel。

## Dashboard安装

``` shell
wget https://raw.githubusercontent.com/kubernetes/dashboard/v2.0.4/aio/deploy/recommended.yaml
```

下载yaml配置文件。

``` shell
kind: Service
apiVersion: v1
metadata:
  labels:
    k8s-app: kubernetes-dashboard
  name: kubernetes-dashboard
  namespace: kubernetes-dashboard
spec:
  type: NodePort
  ports:
    - port: 443
      targetPort: 8443
      nodePort: 30080
```

增加```type: NodePort```。
增加```nodePort: 30080```。

``` shell
sed -i s#imagePullPolicy:\ Always#imagePullPolicy:\ IfNotPresent#g recommended.yaml
```

修改下载镜像策略。

``` shell
docker pull registry:5000/dashboard:v2.0.4
docker pull registry:5000/metrics-scraper:v1.0.4
docker tag registry:5000/dashboard:v2.0.4 kubernetesui/dashboard:v2.0.4
docker tag registry:5000/metrics-scraper:v1.0.4 kubernetesui/metrics-scraper:v1.0.4
```

下载镜像并增加标签。

``` shell
kubectl apply -f recommended.yaml
```

使用yaml配置应用Dashboard。

``` shell
kubectl create serviceaccount dashboard-admin -n kubernetes-dashboard
kubectl create clusterrolebinding dashboard-cluster-admin --clusterrole=cluster-admin --serviceaccount=kubernetes-dashboard:dashboard-admin
kubectl get secret -n kubernetes-dashboard | grep dashboard-admin
kubectl describe secret -n kubernetes-dashboard dashboard-admin-token-vn7z8
```

token可以用来登录Dashboard。
