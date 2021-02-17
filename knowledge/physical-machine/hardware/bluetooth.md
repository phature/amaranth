# 蓝牙设备用于Linux和Windows双系统的配置

## 在Linux系统匹配蓝牙设备

## 在Windows系统匹配蓝牙设备

## 记录Windows系统相关参数值

``` cmd
PSExec.exe -s -i regedit
```

下载PSTools工具才能查看系统隐藏的注册表数据。

``` text
HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Services\BTHPORT\Parameters\Keys\aaaaaaaaaaaa\cccccccccccc
```

aaaaaaaaaaaa，本机蓝牙地址。

cccccccccccc，蓝牙鼠标地址。

EDIV，10进制原值。

ERand，16进制8899 aabb ccdd eeff，转换人成ffee ddcc bbaa 9988后取10进制值。

LTK，16进制原值。

## 修改Linux系统参数值

``` path
/var/lib/bluetooth/AA\:AA\:AA\:AA\:AA\:AA/BB\:BB\:BB\:BB\:BB\:BB/info
```

Key，Windows下LTK的16进制原值。

EDiv，Windows下EDIV的10进制原值。

Rand，Windows下ERand的10进制转换值。

## 修改Linux系统蓝牙鼠标地址

``` shell
sudo mv BB\:BB\:BB\:BB\:BB\:BB CC\:CC\:CC\:CC\:CC\:CC
```

由于蓝牙鼠标设备匹配一次，地址变更一次，要把Linux的蓝牙鼠标地址改成最后使用的Windows的蓝牙鼠标地址。