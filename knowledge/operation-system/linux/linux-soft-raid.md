# Linux软RAID管理

## KVM虚拟机增加磁盘

``` shell
qemu-img create -f qcow2 raid1-01.qcow2 1G
```

创建qcow2格式1GB大小的磁盘文件。

``` shell
cp raid1-01.qcow2 raid1-02.qcow2
```

复制文件，准备好2块磁盘。

把2块磁盘挂载到测试虚拟机。启动虚拟机，测试操作系统是CentOS 7.8.2003。

## 查看新磁盘

``` shell
sudo fdisk -l
```

这里显示是/dev/vdb和/dev/vdc，后面命令根据此处不同做相应调整。

## mdamd安装

``` shell
sudo yum install mdadm -y
```

## 创建RAID

``` shell
sudo mdadm --create /dev/md0 --level=1 --raid-devices=2 /dev/vdb /dev/vdc
```

```/dev/md0```，新设备文件。

```--level=1```，RAID1级别。

```--raid-devices=2```，设备数量为2。

```/dev/vdb /dev/vdc```，组成RAID1的2块磁盘文件。

``` shell
cat /proc/mdstat
```

查看RAID设备状态，设备同步未完成时也能进行分区使用。
