# CentOS 8.3.2011部署Redis副本集

## 相关包安装

``` shell
sudo dnf install gcc make tcl systemd-devel -y
```

## /etc/sysctl.conf文件配置

``` text
vm.overcommit_memory = 1
net.core.somaxconn = 512
```

执行```sudo sysctl -p```使配置生效。

## /etc/default/grub配置使用透明大页面

GRUB_CMDLINE_LINUX参数加上```transparent_hugepage=madvise```，执行```grub2-mkconfig -o /boot/efi/EFI/centos/grug.cfg```。

或者临时执行```sudo echo madvise > /sys/kernel/mm/transparent_hugepage/enabled```使用透明大页面。

## 组和用户创建

``` shell
sudo groupadd -g redis
sudo useradd -g redis -u redis
```

## 相关目录创建

``` shell
sudo mkdir /var/lib/redis
sudo chown redis: /var/lib/redis
sudo mkdir /var/log/redis
sudo chown redis: /var/log/redis
```

## 编译安装

``` shell
wget https://download.redis.io/releases/redis-6.0.9.tar.gz
tar xzf redis-6.0.9.tar.gz
cd redis-6.0.9
make USE_SYSTEMD=yes
make test
sudo make install
```

## /etc/redis/redis-server-6379.conf文件创建

``` shell
sudo mkdir /etc/redis
more /dev/null | sudo tee /etc/redis/redis-server-6379.conf
sudo chmod 644 /etc/redis/redis-server-6379.conf
sudo chown -R redis: /etc/redis
```

## /etc/redis/redis-server-6379.conf文件配置

``` text
bind 0.0.0.0
protected-mode yes
port 6379
tcp-backlog 511
timeout 0
tcp-keepalive 300
daemonize no
supervised systemd
pidfile /var/lib/redis/redis-server-6379.pid
loglevel notice
logfile /var/log/redis/redis-server-6379.log
databases 16
always-show-logo yes
save 900 1
save 300 10
save 60 10000
stop-writes-on-bgsave-error yes
rdbcompression yes
rdbchecksum yes
dbfilename dump.rdb
rdb-del-sync-files no
dir /var/lib/redis/
replica-serve-stale-data yes
replica-read-only yes
repl-diskless-sync no
repl-diskless-sync-delay 5
repl-diskless-load disabled
repl-disable-tcp-nodelay no
replica-priority 100
acllog-max-len 128
lazyfree-lazy-eviction no
lazyfree-lazy-expire no
lazyfree-lazy-server-del no
replica-lazy-flush no
lazyfree-lazy-user-del no
oom-score-adj no
oom-score-adj-values 0 200 800
appendonly no
appendfilename "appendonly.aof"
appendfsync everysec
no-appendfsync-on-rewrite no
auto-aof-rewrite-percentage 100
auto-aof-rewrite-min-size 64mb
aof-load-truncated yes
aof-use-rdb-preamble yes
lua-time-limit 5000
slowlog-log-slower-than 10000
slowlog-max-len 128
latency-monitor-threshold 0
notify-keyspace-events ""
hash-max-ziplist-entries 512
hash-max-ziplist-value 64
list-max-ziplist-size -2
list-compress-depth 0
set-max-intset-entries 512
zset-max-ziplist-entries 128
zset-max-ziplist-value 64
hll-sparse-max-bytes 3000
stream-node-max-bytes 4096
stream-node-max-entries 100
activerehashing yes
client-output-buffer-limit normal 0 0 0
client-output-buffer-limit replica 256mb 64mb 60
client-output-buffer-limit pubsub 32mb 8mb 60
hz 10
dynamic-hz yes
aof-rewrite-incremental-fsync yes
rdb-save-incremental-fsync yes
jemalloc-bg-thread yes

requirepass password
```

## /lib/systemd/system/redis-server-6379.service文件配置

``` text
[Unit]
Description=Redis server
Documentation=https://redis.io/documentation
AssertPathExists=/var/lib/redis
Wants=network-online.target
After=network-online.target

[Service]
ExecStart=/usr/local/bin/redis-server /etc/redis/redis-server-6379.conf
LimitNOFILE=65536
NoNewPrivileges=yes
Type=notify
TimeoutStartSec=infinity
TimeoutStopSec=infinity
UMask=0077
User=redis
Group=redis
WorkingDirectory=/var/lib/redis

[Install]
WantedBy=multi-user.target
```

执行```sudo systemctl enable --now redis-server-6379```启动服务。

## 副本集配置

``` text
slaveof 192.168.122.157 6379
masterauth password
```

两台从服务器和主服务器进行相同配置，```/etc/redis/redis-server-6379.conf```文件末尾增加上面的配置，```slaveof```配置为主服务器的IP和端口。

## /etc/redis/redis-sentinel-26379.conf文件创建

``` shell
more /dev/null | sudo tee /etc/redis/redis-sentinel-26379.conf
sudo chown -R redis: /etc/redis
sudo chmod 644 /etc/redis/redis-sentinel-26379.conf
```

## /etc/redis/redis-sentinel-26379.conf文件配置

``` text
bind 0.0.0.0
port 26379
daemonize no
supervised systemd
pidfile "/var/lib/redis/redis-sentinel-26379.pid"
logfile "/var/log/redis/redis-sentinel-26379.log"
dir "/tmp"
sentinel deny-scripts-reconfig yes

sentinel monitor master6379 192.168.122.156 6379 2
sentinel auth-pass master6379 password
sentinel config-epoch master6379 0
sentinel leader-epoch master6379 2
requirepass password
```

```sentinel monitor mymaster```最好配置为副本服务器。

## /lib/systemd/system/redis-sentinel-26379.service文件配置

``` text
[Unit]
Description=Redis sentinel
Documentation=https://redis.io/documentation
AssertPathExists=/var/lib/redis
Wants=network-online.target
After=network-online.target

[Service]
ExecStart=/usr/local/bin/redis-sentinel /etc/redis/redis-sentinel-26379.conf
LimitNOFILE=65536
NoNewPrivileges=yes
Type=notify
TimeoutStartSec=infinity
TimeoutStopSec=infinity
UMask=0077
User=redis
Group=redis
WorkingDirectory=/var/lib/redis

[Install]
WantedBy=multi-user.target
```

执行```sudo systemctl enable --now redis-sentinel-26379```启动服务。
