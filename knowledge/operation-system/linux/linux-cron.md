# Linux定时任务

## 服务启用

``` shell
sudo systemctl enable --now crond
```

## /etc/crontab编辑

``` text
*/1 * * * * root /root/script.sh
```

## 应用定时任务

``` shell
sudo crontab /etc/crontab
```
