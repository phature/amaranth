# CentOS 7.8.2003配置NTP时间同步

## chrony安装

``` shell
 sudo yum install chrony -y
 ```

## /etc/chrony.conf配置

``` text
server 0.centos.pool.ntp.org iburst
server 1.centos.pool.ntp.org iburst
server 2.centos.pool.ntp.org iburst
server 3.centos.pool.ntp.org iburst
```

修改服务器列表。

## 启用服务

``` shell
sudo systemctl enable --now chronyd
```

## 查看

``` shell
chronyc sources -v
```
