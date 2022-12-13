# Debian 11配置

## TTY字体

``` shell
dpkg-reconfigure console-setup
```

## GRUB

``` shell
sed -i s/GRUB_TIMEOUT=5/GRUB_TIMEOUT=1/g /etc/default/grub
grep GRUB_TIMEOUT /etc/default/grub

sed -i s/timeout=[0-9]*/timeout=1/g /boot/grub/grub.cfg
grep -i timeout /boot/grub/grub.cfg
```

## SSH

``` shell
sed -i '/^\#PermitRootLogin/a\PermitRootLogin yes' /etc/ssh/sshd_config
grep PermitRootLogin /etc/ssh/sshd_config

sed -i '/^\#PasswordAuthentication/a\PasswordAuthentication yes' /etc/ssh/sshd_config
grep PasswordAuthentication /etc/ssh/sshd_config
```

## APPARMOR

``` shell
systemctl disable apparmor
```

## IP

/etc/network/interfaces
```
# This file describes the network interfaces available on your system
# and how to activate them. For more information, see interfaces(5).

source /etc/network/interfaces.d/*

# The loopback network interface
auto lo
iface lo inet loopback

allow-hotplug eth0 eth1

iface eth0 inet static
  address 192.168.122.111
  netmask 255.255.255.0
  gateway 192.168.122.1
  metric 128
iface eth1 inet dhcp
  metric 1

iface eth0 inet6 auto
iface eth1 inet6 auto
```

## HOST

``` shell
echo 191.168.122.111 $HOSTNAME | tee -a /etc/hosts
```

## APT

/etc/apt/sources.list
```
deb http://mirrors.ustc.edu.cn/debian-security bullseye-security main contrib non-free
deb-src http://mirrors.ustc.edu.cn/debian-security bullseye-security main contrib non-free

deb https://mirrors.ustc.edu.cn/debian bullseye main contrib non-free
deb-src https://mirrors.ustc.edu.cn/debian bullseye main contrib non-free

deb https://mirrors.ustc.edu.cn/debian bullseye-updates main contrib non-free
deb-src https://mirrors.ustc.edu.cn/debian bullseye-updates main contrib non-free

deb https://mirrors.ustc.edu.cn/debian bullseye-backports main contrib non-free
deb-src https://mirrors.ustc.edu.cn/debian bullseye-backports main contrib non-free
```
``` shell
apt-get install sudo mdadm nfs-common tar gzip zip unzip telnet wget curl
```

## SUDO

``` shell
usermod -aG sudo $USER
echo "alias sudo='sudo '" | tee -a $HOME/.bashrc
```