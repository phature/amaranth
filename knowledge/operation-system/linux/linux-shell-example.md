# Linux的Shell脚本实例

## 防火墙关闭和开启端口

``` text
#!/bin/bash

for ZONE in `firewall-cmd --get-active-zones | grep -v interfaces`
do
  for PORT in `firewall-cmd --zone=$ZONE --list-all | grep ports | grep -v forward | grep -v source | awk -F ":" '{print $2}'`
  do
    firewall-cmd --zone=$ZONE --remove-port=$PORT --permanent
  done

  for PORT in `grep -v ^# $ZONE`
  do
    firewall-cmd --zone=$ZONE --add-port=$PORT --permanent
  done

  firewall-cmd --reload

  firewall-cmd --zone=$ZONE --list-all
done
```

防火墙关闭和开启端口脚本。

开放的端口保存在```zone```同名文件中。格式为```xxxxx/tcp```或者```xxxxx/udp```，每行一个端口，```#```开始的行为注释。

## 字符串行转列

``` shell
echo "string" | awk '{split($0,values,"")} END{for(i in values) print values[i]}'
```
