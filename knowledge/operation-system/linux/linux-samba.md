# Linux Samba

## 软件包安装

``` shell
sudo dnf install samba samba-common samba-client -y
```

## /etc/samba/smb.conf配置

``` text
# See smb.conf.example for a more detailed config file or
# read the smb.conf manpage.
# Run 'testparm' to verify the config is correct after
# you modified it.

[global]
    workgroup = WORKGROUP
    security = user

    passdb backend = tdbsam

    printing = cups
    printcap name = cups
    load printers = yes
    cups options = raw

[document]
    path = /catalog/document/
    browsable = Yes
    writable = No
    guest ok = Yes
    read only = Yes
    valid users = samba
```

## 用户配置

``` shell
sudo su
smbpasswd –a samba
```

需要登录到root用户才能操作。

## 启用服务

``` shell
sudo systemctl enable --now smb.service
sudo firewall-cmd --permanent --add-service=samba
sudo firewall-cmd --permanent --add-service=samba-client
sudo firewall-cmd --reload
```
