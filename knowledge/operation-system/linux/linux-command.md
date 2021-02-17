# Linux命令

## 命令帮助

``` shell
command -h
command --help
man command
```

Linux命令的帮助查看一般有上面这几种方式。

## 用户管理

```groupadd```，增加组。

```groupdel```，删除组。

```groupmems```，组成员管理。

```groupmod```，修改组。

```passwd```，修改密码。

```useradd```，增加用户。

```userdel```，删除用户。

```usermod```，修改用户。

## 文件操作

```cd```，改变当前目录。

```chmod```，改变文件权限。

```chown```，改变文件所有者。

```cp```，复制目录或文件。

```find```，查找文件。

```ls```，查看当前目录文件列表。

```mkdir```，创建目录。

```mv```，移动目录或文件。

```pwd```，查看当前目录。

```rm```，删除目录或文件。

```rmdir```，删除目录。

## 文件内容操作

```awk```，文本处理。

```cat```，查看文件。

```grep```，查找内容。

```head```，查看文件开头。

```more```，分页查看文件，```space```后翻，```b```前翻。

```sed```，替换文件内容。

```sort```，排序。

```tail```，查看文件结尾。

```vim```或```vi```，文本编辑器。

```wc```，字符统计。

## 压缩解压

```tar```，打包文件。压缩、解压tar.gz或者tar.xz文件。

```unzip```，解压.zip文件。

```zip```，压缩成.zip文件。

## 进程相关

```lsof```，查看进程操作的文件。

```kill```，杀死进程。

```nohup```，让进程在退出会话后仍然能够运行，配合```&```在后台运行。

```ps```，查看进程。

```reboot```，重启计算机。

```shutdown```或者```halt```，关闭或重启计算机。

```top```，查看CPU、内存使用情况。

## 网络相关

```curl```，HTTP请求。

```ip```，IP查看。

```nc```，端口监听，网络测试。

```ping```，网络检测。

```ss```，查看网络状态。

```telnet```，端口检测等。

```wget```，HTTP下载。

## 磁盘相关

```df```，查看磁盘挂载详情。

```du```，磁盘使用统计。

```fdisk```，磁盘分区等。

```mount```，磁盘挂载。

```umount```，磁盘卸载。

## SSH相关

```scp```，远程安全SHELL复制。

```ssh```，远程安全SHELL登录。

```ssh-copy-id```，复制公钥到服务器，实现免密码登录。

```ssh-keygen```，创建密钥。

## 软件仓库相关

```apt```和```apt-get```，```pkg```等，Debian、Ubuntu等发行版。

```dnf```或者```yum```、```rpm```，Fedora、Red Hat Enterprise Linux、CentOS等发行版。

```pacman```，Arch Linux等发行版。

```zypper```、```rpm```，openSUSE等发行版。

## 其他

```chroot```，改变当前根目录。

```echo```，查看变量等。

```export```，设置变量。

```man```，帮助手册。

```su```，切换用户。
