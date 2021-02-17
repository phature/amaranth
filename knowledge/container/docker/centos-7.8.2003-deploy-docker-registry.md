# CentOS 7.8.2003部署Docker Registry

## 拉取Docker Registry镜像

``` shell
docker pull registry:2.7.1
```

## 部署Docker Registry容器

``` shell
sudo mkdir /container/registry/var/lib/registry -p
sudo mkdir /container/registry/auth -p
```

创建目录，/container/registry作为容器运行根目录。下面的var/lib/registry和auth将映射到容器对应的目录。

``` shell
sudo yum install httpd-tools -y
htpasswd -Bbn username "password" | sudo tee /container/registry/auth/htpasswd
```

安装工具并创建密码文件。

``` shell
docker run -d --restart=always --name registry \
    -p 5000:5000 \
    -v /container/registry/var/lib/registry:/var/lib/registry \
    -v /container/registry/auth:/auth \
    -e "REGISTRY_AUTH=htpasswd" \
    -e "REGISTRY_AUTH_HTPASSWD_REALM=Registry Realm" \
    -e REGISTRY_AUTH_HTPASSWD_PATH=/auth/htpasswd \
    registry:2.7.1
```

运行并创建容器。

``` shell
docker ps
curl --anyauth -u "username:password" http://localhost:5000/v2/_catalog
```

查看正在运行的容器。

检验registry的API是否正常。

## 使用Docker Registry

``` shell
vi /etc/hosts
```

``` text
127.0.0.1   registry
```

修改hosts文件，增加registry解析，127.0.0.1实际改为registry私有镜像仓库服务器的IP。

``` shell
sudo vi /etc/docker/daemon.json
```

``` text
{
    "registry-mirrors": [
        "https://registry.docker-cn.com"
    ],
    "insecure-registries": [
        "registry:5000"
    ]
}
```

``` shell
sudo systemctl stop docker
sudo systemctl start docker
```

修改docker的daemon.json配置文件。因为没有配置成HTTSP，需要在insecure-registries节点里配置。

重启docker服务后生效。

``` shell
docker tag registry:2.7.1 registry:5000/registry:2.7.1
```

给需要推送的registry:2.7.1镜像打上registry:5000/registry:2.7.1标签。

``` shell
docker login registry:5000
docker login -u username -p "password" registry:5000
```

登录到私有镜像仓库服务器。两种方式都一样。

``` shell
docker push registry:5000/registry:2.7.1
```

推送到registry:5000私有镜像仓库服务器。

``` shell
docker logout registry:5000
```

退出登录。

``` shell
docker images
docker image rm registry:5000/registry:2.7.1
docker images
```

删除刚才打上的标签，不删除也可以。

## 遗留问题

registry服务器怎么配置成HTTPS协议。

更完善的验证方式，实现pull不需要身份验证，push才需要身份验证。
