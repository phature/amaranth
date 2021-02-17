# Docker镜像相关命令

## docker image build或者docker build

暂缺。

## docker image history或者docker history

``` shell
docker image history [REPOSITORY:TAG]
docker image history [IMAGE ID]
```

查看镜像历史。

## docker image import或者docker import

``` shell
docker image import [FILE] [REPOSITORY:TAG]
```

将从容器导出的快照导入为镜像。

## docker image inspect或者docker inspect

``` shell
docker image inspect [REPOSITORY:TAG]
docker image inspect [IMAGE ID]
```

查看名称为[REPOSITORY:TAG]或者[IMAGE ID]的镜像详情。

## docker image load或者docker load

``` shell
docker image load -i [FILE]
```

将从镜像导出的文件导入为镜像。

## docker image ls或者docker images

``` shell
docker image ls
```

查看镜像列表。

## docker image prune

``` shell
docker image prune -a
```

删除所有未使用的镜像。

## docker image pull或者docker pull

``` shell
docker image pull [REPOSITORY:TAG]
```

从仓库拉取镜像。

若[REPOSITORY]包含[REGISTRY IP][REGISTRY PORT]则从对应的仓库拉取，否则默认从官方仓库拉取。

## docker image push或者docker push

``` shell shell
docker image push [REPOSITORY:TAG]
```

推送镜像到仓库。

[REPOSITORY:TAG]需要存在于```docker image ls```里。

## docker image rm或者docker rmi

``` shell
docker image rm [REPOSITORY:TAG]
docker image rm [IMAGE ID]
```

删除镜像。

## docker image save或者docker save

``` shell
docker image save -o [REPOSITORY:TAG]
docker image save -o [IMAGE ID]
```

将镜像导出为文件。

## docker image tag或者docker tag

``` shell
docker image tag [REPOSITORY:TAG] [NEW REPOSITORY:NEW TAG]
docker image tag [IMAGE ID] [NEW REPOSITORY:NEW TAG]
```

给镜像增加新的标签。
