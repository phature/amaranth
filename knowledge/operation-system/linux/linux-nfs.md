# Linux NFS

## 共享目录准备

``` shell
sudo mkdir /mnt/nfs/share -p
sudo chown -R nobody: /mnt/nfs/share
sudo chmod -R 777 /mnt/nfs/share
```

## 相关包安装

``` shell
sudo dnf install nfs-utils -y
sudo systemctl enable nfs-server.service
```

## /etc/exports配置

``` text
/mnt/nfs/share 192.168.122.0/255.255.255.0(rw,no_root_squash)
```

/mnt/nfs/share，共享目录。

192.168.122.0/255.255.255.0，允许访问的IP。

rw，访问控制。还可以使用sync,wdelay,hide,no_subtree_check,sec=sys,root_squash,no_all_squash等选项。

``` shell
sudo exportfs -rav
sudo exportfs -s
```

让配置生效。

查看有效的配置。

## 打开防火墙

``` shell
sudo firewall-cmd --permanent --add-service=nfs --zone=zone
sudo firewall-cmd --permanent --add-service=rpc-bind --zone=zone
sudo firewall-cmd --permanent --add-service=mountd --zone=zone
sudo firewall-cmd --reload
```

## 客户端安装

``` shell
sudo dnf install nfs-utils nfs4-acl-tools -y
```

## 挂载共享目录

``` shell
sudo showmount -e 192.168.122.101
sudo mount -t nfs 192.168.122.101:/mnt/nfs/share /mnt/101-share
```

查看服务器共享的目录。

挂载共享目录到本地。
