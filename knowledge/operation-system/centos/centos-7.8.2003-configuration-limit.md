# CentOS 7.8.2003配置限额

## /etc/security/limits.conf

请参考注释进行配置，重新登录后生效。

## /etc/systemd/system.conf或者/etc/systemd/user.conf

``` text
DefaultLimitCORE=
DefaultLimitDATA=
DefaultLimitFSIZE=
DefaultLimitMEMLOCK=
DefaultLimitNOFILE=
DefaultLimitRSS=
DefaultLimitSTACK=
DefaultLimitCPU=
DefaultLimitNPROC=
DefaultLimitAS=
DefaultLimitLOCKS=
DefaultLimitSIGPENDING=
DefaultLimitMSGQUEUE=
DefaultLimitNICE=
DefaultLimitRTPRIO=
```

Systemd服务不使用/etc/security/limits.conf配置，而使用/etc/systemd/system.conf和/etc/systemd/user.conf。

上面的参数去掉前面的```Default```可以配置在````.service```文件里。
