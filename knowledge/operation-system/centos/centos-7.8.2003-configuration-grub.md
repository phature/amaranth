# CentOS 7.8.2003配置GRUB2

## /etc/default/grub修改

``` text
GRUB_TIMEOUT=1
```

修改菜单选择等待时间。

## /boot/efi/EFI/centos/grub.cfg配置文件更新

``` shell
sudo grub2-mkconfig -o /boot/efi/EFI/centos/grub.cfg
```

MBR引导的配置文件一般在/boot/grub2/grub.cfg。
