# Docker容器相关命令

## docker container attach或者docker attach

``` shell
docker container attach [CONTAINER ID]
docker container attach [NAMES]
```

依附到运行的容器，尽量不要使用。

## docker container commit或者docker commit

``` shell
docker container commit [CONTAINER ID] [REPOSITORY:TAG]
docker container commit [NAMES] [REPOSITORY:TAG]
```

提交容器变化并创建镜像。

## docker container cp或者docker cp

``` shell
docker container cp -a -L [CONTAINER ID]:[CONTAINER FILE] [FILE]
docker container cp -a -L [FILE] [CONTAINER ID]:[CONTAINER FILE]
docker container cp -a -L [NAMES]:[CONTAINER FILE] [FILE]
docker container cp -a -L [FILE] [NAMES]:[CONTAINER FILE]
```

将容器文件复制到本地。

将本地文件复制到容器。

-a 归档模式复制。

-L 保留符号链接。

## docker container create或者docker create

``` shell
docker container create --name [NAMES] --restart=always -p [HOST PORT]:[CONTAINER PORT] -v [VOLUME]:[CONTAINER PATH] [REPOSITORY:TAG]
docker container create --name [NAMES] --restart=always -p [HOST PORT]:[CONTAINER PORT] -v [VOLUME]:[CONTAINER PATH] [IMAGE ID]
```

从创建容器。

--name [NAMES] 容器名称。

--restart=always Docker服务重启时，始终启动容器。

-p [HOST PORT]:[CONTAINER PORT] 绑定端口，可以写多个```-p```绑定多个端口。

-v [VOLUME]:[CONTAINER PATH] 绑定目录。可以绑定卷或主机目录。可以写多个```-v```绑定多个目录。

更多参数参考```--help```帮助。

## docker container diff或者docker diff

``` shell
docker container diff [CONTAINER ID]
docker container diff [NAMES]
```

查看容器中有变化的文件。

## docker container exec或者docker exec

``` shell
docker container exec -i -t [CONTAINER ID] [CONTAINER COMMAND]
docker container exec -i -t [NAMES] [CONTAINER COMMAND]
```

运行容器中的命令。

-i 运行标准输入。
-t 开启TTY终端。

## docker container export或者docker export

``` shell
docker container export -o [FILE] [CONTAINER ID]
docker container export -o [FILE] [NAMES]
```

导出容器快照。

## docker container inspect或者docker inspect

``` shell
docker container inspect [CONTAINER ID]
docker container inspect [NAMES]
```

查看名称为[CONTAINER ID]或者[NAMES]的容器详情。

## docker container kill或者docker kill

``` shell
docker container kill [CONTAINER ID]
docker container kill [NAMES]
```

杀掉运行中的容器。

## docker container logs或者docker logs

``` shell
docker container logs -f [CONTAINER ID]
docker container logs -f [NAMES]
```

查看容器日志。

## docker container ls或者docker ps

``` shell
docker container ls
docker container ls --all
```

查看容器列表。

--all 包括未运行的容器。

## docker container pause或者docker pause

``` shell
docker container pause [CONTAINER ID]
docker container pause [NAMES]
```

暂停运行的容器。

## docker container port或者docker port

``` shell
docker container port [CONTAINER ID]
docker container port [NAMES]
```

查看容器的端口映射。

## docker container prune

``` shell
docker container prune
```

删除所有已停止的容器，谨慎使用。

## docker container rename或者docker rename

``` shell
docker container rename [CONTAINER ID] [NEW NAMES]
docker container rename [NAMES] [NEW NAMES]
```

修改容器的名字。

## docker container restart或者docker restart

``` shell
docker container restart [CONTAINER ID]
docker container restart [NAMES]
```

重新启动容器。

## docker container rm或者docker rm

``` shell
docker container rm [CONTAINER ID]
docker container rm -f [NAMES]
```

删除容器。

-f 强制删除运行中的容器。

## docker container run或者docker run

创建并运行容器，参考```create```。

-d 后台运行。

## docker container start或者docker start

``` shell
docker container start [CONTAINER ID]
docker container start [NAMES]
```

启动容器。

## docker container stats或者docker stats

``` shell
docker container stats
docker container stats -a
docker container stats [CONTAINER ID]
docker container stats [NAMES]
```

查看容器的运行状态。

-a 包括未运行的容器。

## docker container stop或者docker stop

``` shell
docker container stop [CONTAINER ID]
docker container stop [NAMES]
```

停止容器。

## docker container top或者docker top

``` shell
docker container top [CONTAINER ID]
docker container top [NAMES]
```

查看容器运行的进程。

## docker container unpause或者docker unpause

``` shell
docker container unpause [CONTAINER ID]
docker container unpause [NAMES]
```

恢复暂停的容器。

## docker container update或者docker update

``` shell
docker container update --restart=always [CONTAINER ID]
docker container update --restart=always [NAMES]
```

修改容器的部分配置，端口和卷绑定无法使用此命令修改修改。

更多参数参考```--help```帮助。

## docker container wait或者docker wait

``` shell
docker container wait [CONTAINER ID]
docker container wait [NAMES]
```

等待容器退出并显示退出代码。
