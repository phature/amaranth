# CentOS 7.8.2003安装QEMU/KVM虚拟机

## 虚拟化主机安装

``` shell
sudo yum group install "Virtualization Host" -y
```

## /etc/libvirt/qemu.conf配置

``` text
#spice_listen = "0.0.0.0"
```

去掉注释，可以使用spice协议管理远程虚拟机。它和vnc一样使用相同的59XX端口，自动从5900开始递增。

## 图形客户端安装

``` shell
sudo yum install virt-manager -y
```

## 终端客户端安装

``` shell
sudo yum install libvirt-client -y
```

## 用户授权

``` shell
sudo usermod -aG qemu [USER]
sudo usermod -aG KVM [USER]
sudo usermod -aG libvirt [USER]
```

## 虚拟机继承虚拟化

CPU类型设置为```host-passthrough```。