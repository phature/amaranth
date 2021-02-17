# CentOS 7.8.2003使用RKE部署K8s集群

## /etc/hosts配置

``` text
192.168.122.156 virtual-156
192.168.122.157 virtual-157
192.168.122.158 virtual-158
127.0.0.1 k8s.local
```

根据实际IP和主机名称配置。

## rke安装

``` shell
wget http://rancher-mirror.cnrancher.com/rke/v1.2.5/rke_linux-amd64
chmod 755 rke_linux-amd64
sudo mv rke_linux-amd64 /usr/bin/rke
```

根据实际情况选择[版本](https://github.com/rancher/rke/releases)。rke的操作只需要在1台机器上进行即可。

## 准备ssh令牌登录

``` shell
ssh-keygen
ssh-copy-id develop@virtual-156
ssh-copy-id develop@virtual-157
ssh-copy-id develop@virtual-158
```

## k8s.yml配置

``` shell
rke config -n k8s.yml
```

根据交互提示创建配置文件。

``` text
[+] Cluster Level SSH Private Key Path [~/.ssh/id_rsa]: 
[+] Number of Hosts [1]: 3
[+] SSH Address of host (1) [none]: virtual-156
[+] SSH Port of host (1) [22]: 
[+] SSH Private Key Path of host (virtual-156) [none]: 
[-] You have entered empty SSH key path, trying fetch from SSH key parameter
[+] SSH Private Key of host (virtual-156) [none]: 
[-] You have entered empty SSH key, defaulting to cluster level SSH key: ~/.ssh/id_rsa
[+] SSH User of host (virtual-156) [ubuntu]: develop
[+] Is host (virtual-156) a Control Plane host (y/n)? [y]: 
[+] Is host (virtual-156) a Worker host (y/n)? [n]: y
[+] Is host (virtual-156) an etcd host (y/n)? [n]: y
[+] Override Hostname of host (virtual-156) [none]: 
[+] Internal IP of host (virtual-156) [none]: 
[+] Docker socket path on host (virtual-156) [/var/run/docker.sock]: 
[+] SSH Address of host (2) [none]: virtual-157
[+] SSH Port of host (2) [22]: 
[+] SSH Private Key Path of host (virtual-157) [none]: 
[-] You have entered empty SSH key path, trying fetch from SSH key parameter
[+] SSH Private Key of host (virtual-157) [none]: 
[-] You have entered empty SSH key, defaulting to cluster level SSH key: ~/.ssh/id_rsa
[+] SSH User of host (virtual-157) [ubuntu]: develop
[+] Is host (virtual-157) a Control Plane host (y/n)? [y]: 
[+] Is host (virtual-157) a Worker host (y/n)? [n]: y
[+] Is host (virtual-157) an etcd host (y/n)? [n]: y
[+] Override Hostname of host (virtual-157) [none]: 
[+] Internal IP of host (virtual-157) [none]: 
[+] Docker socket path on host (virtual-157) [/var/run/docker.sock]: 
[+] SSH Address of host (3) [none]: virtual-158
[+] SSH Port of host (3) [22]: 
[+] SSH Private Key Path of host (virtual-158) [none]: 
[-] You have entered empty SSH key path, trying fetch from SSH key parameter
[+] SSH Private Key of host (virtual-158) [none]: 
[-] You have entered empty SSH key, defaulting to cluster level SSH key: ~/.ssh/id_rsa
[+] SSH User of host (virtual-158) [ubuntu]: develop
[+] Is host (virtual-158) a Control Plane host (y/n)? [y]: 
[+] Is host (virtual-158) a Worker host (y/n)? [n]: y
[+] Is host (virtual-158) an etcd host (y/n)? [n]: y
[+] Override Hostname of host (virtual-158) [none]: 
[+] Internal IP of host (virtual-158) [none]: 
[+] Docker socket path on host (virtual-158) [/var/run/docker.sock]: 
[+] Network Plugin Type (flannel, calico, weave, canal, aci) [canal]: 
[+] Authentication Strategy [x509]: 
[+] Authorization Mode (rbac, none) [rbac]: 
[+] Kubernetes Docker image [rancher/hyperkube:v1.19.7-rancher1]: 
[+] Cluster domain [cluster.local]: k8s.local
[+] Service Cluster IP Range [10.43.0.0/16]: 172.17.0.0/16
[+] Enable PodSecurityPolicy [n]: 
[+] Cluster Network CIDR [10.42.0.0/16]: 172.16.0.0/16
[+] Cluster DNS Service IP [10.43.0.10]: 172.17.8.8
[+] Add addon manifest URLs or YAML files [no]:
```

## rke配置k8s集群

``` shell
rke up --config k8s.yml
```

如果报错，重复执行直到成功。

## kubectl

``` shell
mkdir ~/.kube
cp ~/.kube/config
cp kube_config_k8s.yml ~/.kube/config
```

安装```kubectl```后就可以使用相关命令，如果需要复制到另外两台服务器，最好修改文件里对应的IP地址。
