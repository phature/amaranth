# CentOS 7.8.2003部署Rancher高可用

## 参考CentOS 7.8.2003使用RKE部署K8s集群

先部署一个K8s集群。

## /etc/hosts配置

``` text
127.0.0.1 rancher.local
```

## helm安装

``` shell
mkdir ~/rancher/helm -p
cd ~/rancher/helm
wget http://rancher-mirror.cnrancher.com/helm/v3.5.0/helm-v3.5.0-linux-amd64.tar.gz
tar -zxvf helm-v3.5.0-linux-amd64.tar.gz
sudo cp linux-amd64/helm /usr/bin/
```

下载、解压、安装。最新版本参考[https://github.com/helm/helm/tags](https://github.com/helm/helm/tags)。

## helm仓库配置

``` shell
helm repo add rancher-stable http://rancher-mirror.oss-cn-beijing.aliyuncs.com/server-charts/stable
helm repo update
```

## rancher安装

``` shell
kubectl create namespace cattle-system
helm install rancher rancher-stable/rancher \
 --version 2.5.5 \
 --namespace cattle-system \
 --set ingress.tls.source=secret \
 --set hostname=rancher.local
```

## 添加TLS证书

``` shell
kubectl -n cattle-system create secret tls tls-rancher-ingress \
  --cert=tls.crt \
  --key=tls.key
```

## 添加私有CA证书

``` shell
kubectl -n cattle-system create secret generic tls-ca \
  --from-file=cacerts.pem=./cacerts.pem
```
