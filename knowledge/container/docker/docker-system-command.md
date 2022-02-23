# Docker系统相关命令

## docker system df

``` shell

docker system df
```

查看磁盘使用情况。

## docker system events或者docker events

``` shell
docker system events --since "2020-10-29T17:00:00" --until "2020-10-29T17:30:00"
```

查看两个时间之间的事件。

## docker system info或者docker info

``` shell
docker system info
```

查看系统信息。

## docker system prune

``` shell
docker system prune -a
```

删除所有未使用的镜像。
