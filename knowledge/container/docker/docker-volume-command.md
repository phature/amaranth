# Docker卷相关命令

Docker卷存放在/var/lib/docker/volumes/目录下。

尽量使用卷绑定到容器，而不是使用目录绑定。

## docker volume create

``` shell
docker volume create [VOLUME NAME]
```

创建名称为[VOLUME NAME]的卷。

## docker volume inspect或者docker inspect

``` shell
docker volume inspect [VOLUME NAME]
```

查看名称为[VOLUME NAME]的卷详情。

## docker volume ls

``` shell
docker volume ls
```

查看卷列表。

## docker volume prune

``` shell
docker volume prune
```

删除所有未使用的卷。

## docker volume rm

``` shell
docker volume create [VOLUME NAME]
```

删除名称为[VOLUME NAME]的卷。
