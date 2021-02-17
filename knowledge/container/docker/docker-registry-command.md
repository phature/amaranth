# Docker仓库相关命令

## docker search

``` shell
docker search -f stars=128 -f is-official=false -f is-automated=true --limit 100 [TERM]
```

查询官方Registry（[https://hub.docker.com/](https://hub.docker.com/)）上包含[TERM]关键字的镜像。

-f stars=128 评星达到或超过128个。

-f is-official=false 非官方认证。

-f is-automated=true 非自动构建。

--limit 100 返回最多100条记录。

## docker login

``` shell
docker login [IP:PORT]
docker login -u [USER] -p [PASSWORD] [IP:PORT]
```

登入[IP:PORT]的Registry服务器。

## docker logout

``` shell
docker logout [IP:PORT]
```

登出[IP:PORT]的Registry服务器。
