# CentOS 7.8.2003部署Docker

## yum安装Docker

``` shell
sudo yum install docker -y
```

## 镜像仓库配置

``` shell
sudo vi /etc/docker/daemon.json
```

``` text
{
    "registry-mirrors": [
        "https://registry.docker-cn.com"
    ]
}
```

节点registry-mirrors配置镜像仓库的服务器地址。例如使用```https://kfwkfulq.mirror.aliyuncs.com```等。

修改配置需要重启docker服务才能生效。

## 启用Docker服务

``` shell
sudo systemctl enable --now docker
```

## 加入用户组

``` shell
groupadd -g docker
usermod -aG docker [USER]
```

## cgroups v2错误

``` text
GRUB_CMDLINE_LINUX="rd.lvm.lv=os/root rhgb quiet systemd.unified_cgroup_hierarchy=0"
```

修改```/etc/default/grub```，加上```systemd.unified_cgroup_hierarchy=0```，并重新生成grub.cfg文件。
