# Maven

## ~/.m2/settings.xml配置

``` text
<?xml version="1.0" encoding="utf-8"?>
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                          https://maven.apache.org/xsd/settings-1.0.0.xsd">
    <profiles>
        <profile>
            <id>jdk</id>
            <activation>
                <activeByDefault>true</activeByDefault>
            </activation>
            <properties>
                <maven.compiler.source>1.8</maven.compiler.source>
                <maven.compiler.target>1.8</maven.compiler.target>
                <maven.compiler.compilerVersion>1.8</maven.compiler.compilerVersion>
                <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
            </properties>
        </profile>
    </profiles>
    <mirrors>
        <mirror>
            <id>aliyun</id>
            <name>aliyun</name>
            <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
            <mirrorOf>central</mirrorOf>
        </mirror>
    </mirrors>
</settings>
```

## 本地jar包安装

[ojdbc8](./maven/ojdbc8.jar)

``` shell
mvn install:install-file -DgroupId=com.oracle -DartifactId=ojdbc8 -Dversion=12.2.0.1.0 -Dpackaging=jar -Dfile=ojdbc8.jar
```
