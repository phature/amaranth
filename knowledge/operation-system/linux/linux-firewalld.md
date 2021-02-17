# Linux Firewalld防火墙服务

``` shell
systemctl enable firewalld
```

启用服务。

``` shell
systemctl disable firewalld
```

禁用服务。

``` shell
systemctl start firewalld
```

启动服务。

``` shell
sudo systemctl stop firewalld
```

停止服务。

``` shell
sudo firewall-cmd --permanent --add-port=xxxxx/tcp
```

永久开放端口。

``` shell
sudo firewall-cmd --permanent --remove-port=xxxxx/tcp
```

永久关闭端口。

``` shell
sudo firewall-cmd --reload
```

重新加载规则。

``` shell
firewall-cmd --list-all
```

查看当前配置。

以上命令都是操作默认```zone```，如要操作特定```zone```可以使用```--zone=```参数。更多操作请参考命令帮助。
