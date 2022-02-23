# CentOS 7.8.2003部署RabbitMQ集群

## 官方资料

[https://www.rabbitmq.com/documentation.html](https://www.rabbitmq.com/documentation.html)

## 服务器准备

RabbitMQ集群，最少需要2台服务器，我们现在使用3台服务器。

/etc/hosts配置

``` text
192.168.122.101 machine-101
192.168.122.102 machine-102
192.168.122.103 machine-103
```

## /etc/yum.repos.d/rabbitmq.repo源配置

``` text
[bintray-rabbitmq-server]
name=bintray-rabbitmq-rpm
baseurl=https://dl.bintray.com/rabbitmq/rpm/rabbitmq-server/v3.8.x/el/7/
gpgcheck=0
repo_gpgcheck=0
enabled=1

[bintray-rabbitmq-erlang]
name=rabbitmq-erlang
baseurl=https://dl.bintray.com/rabbitmq-erlang/rpm/erlang/22/el/7
gpgcheck=1
gpgkey=https://dl.bintray.com/rabbitmq/Keys/rabbitmq-release-signing-key.asc
repo_gpgcheck=0
enabled=1
```

## 导入密钥

``` shell
sudo rpm --import https://github.com/rabbitmq/signing-keys/releases/download/2.0/rabbitmq-release-signing-key.asc
```

导入密钥。

## RabbitMQ安装

``` shell
sudo yum install rabbitmq-server -y
```

## 服务启用

``` shell
sudo systemctl enable --now rabbitmq-server
sudo firewall-cmd --permanent --add-port=4369/tcp
sudo firewall-cmd --permanent --add-port=15672/tcp
sudo firewall-cmd --permanent --add-port=25672/tcp
sudo firewall-cmd --reload
```

用浏览器打开[http://localhost:15672](http://localhost:15672)进行验证。默认账号guest、密码guest，这个账号只能本地登录。

4369端口，客户端连接。

15672端口，WEB管理后台端口。

25672端口，集群服务器通信端口。

## 复制密钥

``` shell
scp root@machine-101:/var/lib/rabbitmq/.erlang.cookie /var/lib/rabbitmq/.erlang.cookie
```

在machine-102和machine-103上执行。

## 加入集群

``` shell
sudo rabbitmqctl stop_app
sudo rabbitmqctl join_cluster rabbit@machine-101
sudo rabbitmqctl start_app
```

在machine-101和machine-102上执行操作，可以看到三台机器已经组成集群。

## 插件启用

``` shell
sudo rabbitmq-plugins enable rabbitmq_management
sudo rabbitmq-plugins enable rabbitmq_mqtt
sudo rabbitmq-plugins enable rabbitmq_web_mqtt
```

每台服务器都要执行操作。

组件一般在/usr/lib/rabbitmq/lib/rabbitmq_server-3.8.3/plugins目录下，需要启用哪些组件可以参考上面的命令。

## 虚拟主机和账号创建

``` shell
sudo rabbitmqctl add_user root password
sudo rabbitmqctl set_user_tags root administrator

sudo rabbitmqctl add_vhost develop

sudo rabbitmqctl set_permissions --vhost / root ".*" ".*" ".*"
sudo rabbitmqctl set_permissions --vhost develop root ".*" ".*" ".*"

sudo rabbitmqctl add_user develop password
sudo rabbitmqctl set_permissions --vhost develop develop ".*" ".*" ".*"
```

只需在一台服务器上执行操作。

## 镜像策略配置

``` shell
sudo rabbitmqctl set_policy --vhost / --priority 1 --apply-to all cluster-mirror "^" "{'ha-mode':'all','ha-sync-mode':'automatic'}"
sudo rabbitmqctl set_policy --vhost develop --priority 1 --apply-to all cluster-mirror "^" "{'ha-mode':'all','ha-sync-mode':'automatic'}"
```

只需在一台服务器上执行操作。

默认策略下，集群仅同步元数据，消息内容只存在单一节点上，当在其他节点请求消息时，其他节点向消息所在节点请求数据再返回，这样有消息数据的节点故障时，消息就会丢失。而上面的镜像策略会把消息自动同步到所有的集群节点，避免单一节点故障造成的消息丢失。
