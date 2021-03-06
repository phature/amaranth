# CentOS 8.0.1905安装

## BIOS设置启动方式

现在PC主要有两种启动方式，Legacy和EFI/UEFI。

Legacy需要从一个MBR分区的硬盘启动。

EFI/UEFI需要从一个GPT分区的硬盘启动。

推荐使用EFI/UEFI方式启动。

## 安装介质准备

从[https://www.centos.org/](https://www.centos.org/)下载安装光盘镜像（建议使用国内镜像网站下载）。

![format-iso](./centos-8.0.1905-install/format-iso.png)

使用FAT32文件格式格式化一个优盘或者移动硬盘的分区，标卷为```ISO```。

复制光盘镜像文件到磁盘分区。

## 安装过程

![grub-menu](./centos-8.0.1905-install/grub-menu.png)

从安装介质启动进入到GRUB引导界面。

按```up```键选择第1项。再按```e```进入编辑界面。

![grub-edit](./centos-8.0.1905-install/grub-edit.png)

将```LABEL=CentOS-8-BaseOS-x86_64```改为```LABEL=ISO```，```ISO```为FAT32分区标卷名称。

按```Ctrl```+```x```或者```F10```继续启动。

![language](./centos-8.0.1905-install/language.png)

进入语言选择界面，下一步继续。

![configuration](./centos-8.0.1905-install/configuration.png)

进入配置界面，需要完成相关配置后才能继续。

![network](./centos-8.0.1905-install/network.png)

选择网络配置，可以设置```Host Name```，激活配置网卡等等。

![timezone](./centos-8.0.1905-install/timezone.png)

时间配置，配置时区。

![software](./centos-8.0.1905-install/software.png)

软件配置，根据需要选择。

![tty3](./centos-8.0.1905-install/tty3.png)

按```Ctrl```+```Alt```+```F3```切换到TTY3，可以在终端执行命令。

按```Ctrl```+```Alt```+```F6```切换回图形安装界面。

![fdisk-list](./centos-8.0.1905-install/fdisk-list.png)

``` shell
fdisk -l
```

查看可以使用的磁盘。一般SATA磁盘显示为```/dev/sda```、```/dev/sdb```等，这里是虚拟机，磁盘为```/dev/vda```。

![format](./centos-8.0.1905-install/fdisk-gpt.png)

``` shell
fdisk /dev/vda
```

对```/dev/vda```磁盘进行分区，进入fdisk命令界面。

输入```g```创建新的GPT分区表，此操作将使整个磁盘数据丢失，请先备份磁盘数据。

![fdisk-efi](./centos-8.0.1905-install/fdisk-efi.png)

输入```n```创建新分区。

分区编号默认为1，按```Enter```使用默认值。

按```Enter```使用默认开始扇区，一般使用连续扇区不需要自己输入开始扇区。

输入```+1G```表示分区大小为1G，自动计算结束扇区。

输入```t```改变分区类型。

选择需要操作的分区，因为现在只有1个分区，已经自动选择。

输入```1```选择EFI分区类型。更多类型可以输入```L```查看。

输入```p```查看当前分区明细。

![fdisk-other](./centos-8.0.1905-install/fdisk-other.png)

前面已经创建EFI分区，准备挂载到```/boot/efi```。

下面准备一个Linux分区，准备挂载到```/boot```。

再准备一个LVM分区，准备挂载```/```和交换分区。因为不能从LVM分区启动，所以需要一个独立的分区挂载```/boot```。

继续创建其他分区。

![lvm](./centos-8.0.1905-install/lvm.png)

``` shell
pvcreate /dev/vda3
```

将```/dev/vda3```创建为物理卷。

``` shell
vgcreate centos /dev/vda3
```

创建名称为```centos```的卷组，卷组包括一个```/dev/vda3```物理卷。

``` shell
lvcreate -n root -L 64G centos
```

在```centos```卷组上创建名称为```root```的逻辑卷，大小为64GB。

``` shell
lvcreate -n swap -L 8G centos
```

在```centos```卷组上创建名称为```swap```的逻辑卷，大小为8GB。

LVM可以将多个物理磁盘组成卷组，再在卷组上划分逻辑卷，具有非常好的扩展性。

![disk](./centos-8.0.1905-install/disk.png)

切换回图形安装界面进行磁盘配置，选择```Custom```。

![disk-rescan](./centos-8.0.1905-install/disk-rescan.png)

扫描磁盘变动，使得在终端进行的磁盘操作能够在图形界面正确显示。

![mount-efi](./centos-8.0.1905-install/mount-efi.png)

挂载EFI分区，注意挂载路径和文件系统类型。

![mount-boot](./centos-8.0.1905-install/mount-boot.png)

挂载启动分区。

![mount-root](./centos-8.0.1905-install/mount-root.png)

挂载根分区。

![mount-swap](./centos-8.0.1905-install/mount-swap.png)

挂载交换分区。

![mount-confirm](./centos-8.0.1905-install/mount-confirm.png)

磁盘分区确认。

![root](./centos-8.0.1905-install/root.png)

所有配置完成后，下一步继续安装。

安装过程中可以配置root用户的密码。

![user](./centos-8.0.1905-install/user.png)

创建新用户。

![install](./centos-8.0.1905-install/install.png)

等待安装完成，移除安装介质，重新启动计算机。
