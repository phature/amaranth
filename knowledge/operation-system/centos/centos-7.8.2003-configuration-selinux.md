# CentOS 7.8.2003配置SELINUX

## 命令配置

``` shell
setenforce 0
```

禁用，计算机重启失效。

``` shell
setenforce 1
```

启用，计算机重启失效。

``` shell
getenforce
```

查看。

## /etc/selinux/config配置

请参考注释进行配置，计算机重启后生效。
