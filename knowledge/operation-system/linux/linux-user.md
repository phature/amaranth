# Linux用户和权限

``` text
-rw-r--r--  1 root root   153567 Aug 26 01:27 config-3.10.0-1127.19.1.el7.x86_64
drwx------  3 root root     4096 Jan  1  1970 efi
drwxr-xr-x. 2 root root       27 Oct 15 11:57 grub
drwx------. 2 root root       21 Oct 15 14:56 grub2
-rw-------. 1 root root 61920389 Oct 15 12:00 initramfs-0-rescue-ba68378b118b4c45ba1c0fe651efc928.img
-rw-------  1 root root 21036714 Oct 28 00:26 initramfs-3.10.0-1127.19.1.el7.x86_64.img
-rw-------  1 root root 13595449 Oct 15 15:00 initramfs-3.10.0-1127.19.1.el7.x86_64kdump.img
-rw-r--r--  1 root root   320536 Aug 26 01:27 symvers-3.10.0-1127.19.1.el7.x86_64.gz
-rw-------  1 root root  3612420 Aug 26 01:27 System.map-3.10.0-1127.19.1.el7.x86_64
-rwxr-xr-x. 1 root root  6762688 Oct 15 12:01 vmlinuz-0-rescue-ba68378b118b4c45ba1c0fe651efc928
-rwxr-xr-x  1 root root  6765160 Aug 26 01:27 vmlinuz-3.10.0-1127.19.1.el7.x86_64
```

```ls -l /boot```命令的结果。

第1列，包含11个字符。第1个字符表示文件类型，-表示文件，d表示目录，l表示链接；第2到10个字符表示读、写、执行权限，前面三个表示用户权限，中间3个表示组权限，最后3个表示其他人权限；第11个字符表示ACL（访问控制列表）。

第2列，文件所属的用户。

第3列，文件所属的组。

第4列，文件大小。

第5、6、7列，文件时间。

第8列，文件名。

Linux权限控制的所有者维度有3个类别：用户、组、其他人。访问控制维度有3种，读、写、执行。根据这两个维度决定用户最终能对这个文件做什么。

只有标识为可执行的文件，才允许加载到内存中执行，和Windows根据文件后缀名来判断是完全不同的，Linux的可执行文件可以没有后缀名，或者可以有任意的后缀名。
