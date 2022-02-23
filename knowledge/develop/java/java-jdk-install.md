# JDK安装

JDK有不同的实现，一般常用的是Oracle官方版本和openjdk版本。

JAVA从1.8以后，加快了版本迭代，每隔6个月发布一个有6个月支持的版本，命名改为9、10、11这样的规则。其中JAVA 11是一个LTS（Long Time Support）版本，有3年的更新支持。

## CentOS下安装

``` shell
sudo dnf install java-11-openjdk-devel -y
```

## JAVA版本切换

``` shell
sudo alternatives --config java
```

可以在多个版本的java中选择一个版本。
