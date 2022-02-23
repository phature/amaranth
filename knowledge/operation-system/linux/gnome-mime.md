# GNOME配置MIME类型

## 创建文件图标

``` shell
sudo cp xmind.png /usr/share/icons/hicolor/scalable/apps/
 sudo gtk-update-icon-cache /usr/share/icons/hicolor/
 ```

## xmind.xml配置

``` shell
cd /usr/share/mime/packages
sudo vi xmind.xml
```

配置文件内容如下：

``` text
<?xml version="1.0" encoding="UTF-8"?>
<mime-info xmlns="http://www.freedesktop.org/standards/shared-mime-info">
  <mime-type type="x-scheme-handler/xmind">
    <alias type="x-scheme-handler/xmind-zen"/>
    <comment xml:lang="en">XMind File</comment>
    <glob pattern="*.xmind" />
    <generic-icon name="xmind"/>
  </mime-type>
</mime-info>
```

## 更新数据库

``` shell
sudo update-mime-database /usr/share/mime/
```
