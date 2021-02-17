# CentOS 7.8.2003部署Oracle 12c

## 操作系统版本

``` shell
cat /etc/redhat-release
```

CentOS Linux release 7.8.2003 (Core)

## Oracle版本

Oracle 12c

linuxx64_12201_database.zip

## 依赖包安装

``` shell
sudo yum install binutils libcap libstdc++.i686 libstdc++ gcc gcc-c++ \
  glibc.i686 glibc glibc-devel.i686 glibc-devel \
  ksh libaio.i686 libaio libaio-devel.i686 libaio-devel \
  libgcc.i686 libgcc libstdc++.i686 libstdc++ libstdc++-devel.i686 libstdc++-devel libXi.i686 \
  libXi libXtst.i686 libXtst make sysstat libnsl \
  compat-libcap1 net-tools smartmontools zip unzip -y
```

## /etc/sysctl.conf文件配置

``` text
fs.aio-max-nr = 1048576
fs.file-max = 6815744
kernel.shmall = 2097152
kernel.shmmax = 4294967295
kernel.shmmni = 4096
kernel.sem = 250 32000 100 128
net.ipv4.ip_local_port_range = 9000 65500
net.core.rmem_default = 262144
net.core.rmem_max = 4194304
net.core.wmem_default = 262144
net.core.wmem_max = 1048576
```

``` shell
sysctl -p
```

## 组和用户创建

``` shell
groupadd -g 54321 oinstall

groupadd -g 54322 dba
groupadd -g 54323 oper
groupadd -g 54324 backupdba
groupadd -g 54325 dgdba
groupadd -g 54326 kmdba
groupadd -g 54327 asmdba
groupadd -g 54328 asmoper
groupadd -g 54329 asmadmin
groupadd -g 54330 racdba
```

``` shell
useradd -g oinstall -u 54321 oracle

usermod -aG dba oracle
usermod -aG oper oracle
usermod -aG backupdba oracle
usermod -aG dgdba oracle
usermod -aG kmdba oracle
usermod -aG asmdba oracle
usermod -aG racdba oracle
```

``` shell
useradd -g oinstall -u 54331 grid

usermod -aG dba grid
usermod -aG asmdba grid
usermod -aG asmoper grid
usermod -aG asmadmin grid
usermod -aG racdba grid
```

## 安装目录创建

``` shell
mkdir /opt/oracle
chown oracle.oinstall /opt/oracle
```

## /etc/security/limits.conf文件配置

``` text
oracle soft nproc 2048
oracle hard nproc 16384
oracle soft nofile 1024
oracle hard nofile 65536
oracle soft stack 10240
oracle hard stack 32768
oracle soft memlock 134217728
oracle hard memlock 134217728
```

## /etc/oraInst.loc文件配置

``` text
inventory_loc=/opt/oracle/x86_64/database/oraInventory/12c/
inst_group=oinstall
```

## 切换到oracle用户登录

``` shell
su - oracle
```

因为oracle用户没有设置密码，使用```CTRL```+```ALT```+```F1~F12```切换到别的TTY，然后用root用户登录，再切换到oracle用户。

## /home/oracle/install.rsp软件安装应答文件创建

``` text
oracle.install.responseFileVersion=/oracle/install/rspfmt_dbinstall_response_schema_v12.2.0
oracle.install.option=INSTALL_DB_SWONLY

INVENTORY_LOCATION=/opt/oracle/x86_64/database/oraInventory/12c
ORACLE_BASE=/opt/oracle/x86_64/database/server/12c/
ORACLE_HOME=/opt/oracle/x86_64/database/server/12c/home

UNIX_GROUP_NAME=oinstall
oracle.install.db.OSDBA_GROUP=dba
oracle.install.db.OSOPER_GROUP=oper
oracle.install.db.OSBACKUPDBA_GROUP=backupdba
oracle.install.db.OSDGDBA_GROUP=dgdba
oracle.install.db.OSKMDBA_GROUP=kmdba
oracle.install.db.OSRACDBA_GROUP=racdba

oracle.install.db.rac.configurationType=
oracle.install.db.CLUSTER_NODES=
oracle.install.db.isRACOneInstall=false
oracle.install.db.racOneServiceName=
oracle.install.db.rac.serverpoolName=
oracle.install.db.rac.serverpoolCardinality=0

oracle.install.db.config.starterdb.type=GENERAL_PURPOSE
oracle.install.db.config.starterdb.globalDBName=develop
oracle.install.db.config.starterdb.SID=develop
oracle.install.db.ConfigureAsContainerDB=false
oracle.install.db.config.PDBName=
oracle.install.db.config.starterdb.characterSet=AL32UTF8
oracle.install.db.config.starterdb.memoryOption=true
oracle.install.db.config.starterdb.memoryLimit=512
oracle.install.db.config.starterdb.installExampleSchemas=false
oracle.install.db.config.starterdb.password.ALL=Oracle12c
oracle.install.db.config.starterdb.password.SYS=
oracle.install.db.config.starterdb.password.SYSTEM=
oracle.install.db.config.starterdb.password.DBSNMP=
oracle.install.db.config.starterdb.password.PDBADMIN=
oracle.install.db.config.starterdb.managementOption=DEFAULT
oracle.install.db.config.starterdb.omsHost=
oracle.install.db.config.starterdb.omsPort=0
oracle.install.db.config.starterdb.emAdminUser=
oracle.install.db.config.starterdb.emAdminPassword=
oracle.install.db.config.starterdb.enableRecovery=false
oracle.install.db.config.starterdb.storageType=FILE_SYSTEM_STORAGE
oracle.install.db.config.starterdb.fileSystemStorage.dataLocation=/opt/oracle/x86_64/database/server/12c/oradata
oracle.install.db.config.starterdb.fileSystemStorage.recoveryLocation=
oracle.install.db.config.asm.diskGroup=
oracle.install.db.config.asm.ASMSNMPPassword=
MYORACLESUPPORT_USERNAME=
MYORACLESUPPORT_PASSWORD=
SECURITY_UPDATES_VIA_MYORACLESUPPORT=false
DECLINE_SECURITY_UPDATES=true
PROXY_HOST=
PROXY_PORT=
PROXY_USER=
PROXY_PWD=
COLLECTOR_SUPPORTHUB_URL=
```

## 数据库软件安装

``` shell
./runInstaller -silent -ignoreSysPrereqs -ignorePrereq -showProgress -responseFile /home/oracle/install.rsp
```

解压oracle安装文件（例如：/opt/oracle/x86_64/database/install/12c目录），并进入目录执行安装命令。

``` shell
sudo /opt/oracle/x86_64/database/server/oraInventory/12c/orainstRoot.sh
sudo /opt/oracle/x86_64/database/server/12c/home/root.sh
```

根据提示使用root用户执行两个脚本。

## /home/oracle/netca.rsp监听配置应答文件创建

``` text
[GENERAL]
RESPONSEFILE_VERSION="12.2"
CREATE_TYPE="CUSTOM"
SHOW_GUI=false

[oracle.net.ca]
INSTALLED_COMPONENTS={"server","net8","javavm"}
INSTALL_TYPE=""typical""
LISTENER_NUMBER=1
LISTENER_NAMES={"LISTENER"}
LISTENER_PROTOCOLS={"TCP;1521"}
LISTENER_START=""LISTENER""
NAMING_METHODS={"TNSNAMES","ONAMES","HOSTNAME"}
NSN_NUMBER=1
NSN_NAMES={"EXTPROC_CONNECTION_DATA"}
NSN_SERVICE={"PLSExtProc"}
NSN_PROTOCOLS={"TCP;HOSTNAME;1521"}
```

## 数据库监听配置

``` text
/opt/oracle/x86_64/database/server/12c/home/bin/netca -silent -responsefile /home/oracle/netca.rsp
```

## /opt/oracle/x86_64/database/server/12c/home/network/admin/sqlnet.ora配置

``` text
SQLNET.ALLOWED_LOGON_VERSION_SERVER=11
SQLNET.ALLOWED_LOGON_VERSION_CLIENT=11
```

允许11g的客户端登录。

## /home/oracle/dbca.rsp监听配置应答文件创建

``` text
responseFileVersion=/oracle/assistants/rspfmt_dbca_response_schema_v12.2.0
gdbName=DEVELOP
sid=DEVELOP
databaseConfigType=
RACOneNodeServiceName=
policyManaged=
createServerPool=
serverPoolName=
cardinality=
force=
pqPoolName=
pqCardinality=
createAsContainerDatabase=
numberOfPDBs=
pdbName=
useLocalUndoForPDBs=
pdbAdminPassword=
nodelist=
templateName=General_Purpose.dbc
sysPassword=Oracle12c
systemPassword=Oracle12c
oracleHomeUserPassword=
emConfiguration=
emExpressPort=5500
runCVUChecks=
dbsnmpPassword=
omsHost=
omsPort=
emUser=
emPassword=
dvConfiguration=
dvUserName=
dvUserPassword=
dvAccountManagerName=
dvAccountManagerPassword=
olsConfiguration=
datafileJarLocation=
datafileDestination=/opt/oracle/x86_64/database/server/12c/oradata
recoveryAreaDestination=
storageType=
diskGroupName=
asmsnmpPassword=
recoveryGroupName=
characterSet=UTF8
nationalCharacterSet=UTF8
registerWithDirService=
dirServiceUserName=
dirServicePassword=
walletPassword=
listeners=LISTENER
variablesFile=
variables=
initParams=
sampleSchema=
memoryPercentage=
databaseType=
automaticMemoryManagement=
totalMemory=1024
```

## 数据库实例配置

``` text
/opt/oracle/x86_64/database/server/12c/home/bin/dbca -silent -createDatabase -responseFile /home/oracle/dbca.rsp
```

## vi /etc/oratab配置

``` text
develop:/opt/oracle/x86_64/database/server/12c/home:N
```

最后的N改为Y。

## /lib/systemd/system/oracle.service服务配置

``` text
[Unit]
Description=Oracle  x86_64 Database Server 12c
After=syslog.target network.target

[Service]
LimitNPROC=16384
LimitNOFILE=65536
LimitSTACK=infinity
LimitMEMLOCK=infinity
RemainAfterExit=yes
RemainAfterExit=yes
User=oracle
Group=oinstall
ExecStart=/opt/oracle/x86_64/database/server/12c/home/bin/dbstart /opt/oracle/x86_64/database/server/12c/home
ExecStop=/opt/oracle/x86_64/database/server/12c/home/bin/dbshut /opt/oracle/x86_64/database/server/12c/home

[Install]
WantedBy=multi-user.target
```

## 启用服务

``` shell
sudo systemctl enable --now oracle.service
```

## /home/oracle/.bashrc环境变量配置

``` text
export ORACLE_HOME=/opt/oracle/x86_64/database/server/12c/home
export ORACLE_SID=DEVELOP
export PATH=$PATH:$ORACLE_HOME/bin
```

重新登录后生效。

``` shell
sqlplus / as sysdba
```

使用sys登录到oracle。

## 遗留问题

三种应答文件的更多具体配置。
