# CentOS 7.8.2003部署MongoDB集群

## 官方资料

[https://docs.mongodb.com/manual/tutorial/install-mongodb-on-red-hat/](https://docs.mongodb.com/manual/tutorial/install-mongodb-on-red-hat/)

[http:// docs.mongodb.com /manual/tutorial/deploy-replica-set/](http:// docs.mongodb.com /manual/tutorial/deploy-replica-set/)

[http:// docs.mongodb.com /manual/core/authorization/](http:// docs.mongodb.com /manual/core/authorization/)

## 服务器准备

为了实现MongoDB集群，最少需要3台服务器。

/etc/hosts配置

``` text
192.168.122.101 machine-101
192.168.122.102 machine-102
192.168.122.103 machine-103
```

## /etc/yum.repos.d/mongodb-org-4.2.repo源配置

 ``` text
[mongodb-org-4.2]
name=MongoDB Repository
baseurl=https://repo.mongodb.org/yum/redhat/$releasever/mongodb-org/4.2/x86_64/
gpgcheck=1
enabled=1
gpgkey=https://www.mongodb.org/static/pgp/server-4.2.asc
```

## MongoDB安装

``` shell
sudo yum install mongodb-org -y
```

## /etc/mongod.conf配置

``` text
# mongod.conf

# for documentation of all options, see:
#   http://docs.mongodb.org/manual/reference/configuration-options/

# where to write logging data.
systemLog:
  destination: file
  logAppend: true
  path: /var/log/mongodb/mongod.log

# Where and how to store data.
storage:
  dbPath: /var/lib/mongo
  journal:
    enabled: true
#  engine:
#  wiredTiger:

# how the process runs
processManagement:
  fork: true  # fork and run in background
  pidFilePath: /var/run/mongodb/mongod.pid  # location of pidfile
  timeZoneInfo: /usr/share/zoneinfo

# network interfaces
net:
  port: 27017
  bindIp: 127.0.0.1  # Enter 0.0.0.0,:: to bind to all IPv4 and IPv6 addresses or, alternatively, use the net.bindIpAll setting.


#security:

#operationProfiling:

#replication:

#sharding:

## Enterprise-Only Options

#auditLog:

#snmp:
```

修改内容：

``` text
  bindIp: 0.0.0.0
```

绑定所有IP。

``` text
replication:
  replSetName: cluster
```

副本集的名字。

## 服务启用

``` shell
sudo systemctl enable --now mongod
sudo firewall-cmd --permanent --add-port=27017/tcp
sudo firewall-cmd --reload
```

## 副本集初始化

``` shell
mongo
```

在任意一台机器上进入MongoDB的Shell，执行下面的命令：

``` text
rs.initiate( {
   _id : "cluster",
   members: [
      { _id:1, host:"machine-101:27017", priority:1 },
      { _id:2, host:"machine-102:27017", priority:2 },
      { _id:3, host:"machine-103:27017", priority:3 }
   ]
})
```

## 安全验证启用

MongoDB默认允许直接连接，在使用0.0.0.0绑定后，会带来严重的安全隐患，因此需要创建用户并启用安全验证。

``` shell
mongo
```

在任意一台机器上进入MongoDB的Shell。

``` text
use admin
```

切换到admin库。

``` text
db.createUser(
  {
    user: "root",
    pwd: "password",
    roles: [ { role: "root", db: "admin" } ]
  }
)
```

创建超级用户。

``` shell
openssl rand -base64 756 | sudo tee /etc/mongodb.key
scp /etc/mongodb.key root@machine-102:/etc/mongodb.key
scp /etc/mongodb.key root@machine-103:/etc/mongodb.key
```

创建密钥文件，并复制到另外两台服务器。

``` shell
sudo chown mongod.mongod mongodb.key
sudo chmod 400 mongodb.key
```

在3台机器上修改文件权限。注意，一定要修改文件的用户和权限，否则启动会出错。

``` text
security:
  authorization: "enabled"
  keyFile: "/etc/mongodb.key"
```

/etc/mongod.conf配置修改。重新启动服务。
