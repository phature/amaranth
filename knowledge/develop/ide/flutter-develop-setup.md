# Flutter开发环境配置

## 依赖安装

``` shell
sudo dnf install git maven java-1.8.0-openjdk-devel -y
```

## Flutter下载

``` shell
git clone -b master https://mirrors.tuna.tsinghua.edu.cn/git/flutter-sdk.git flutter/sdk
```

下载Flutter的SDK。

## ~/.gradle/init.gradle配置仓库

``` text
allprojects {
    buildscript {
        repositories {
            mavenLocal()
            maven { url 'https://maven.aliyun.com/repository/google' }
            maven { url 'https://maven.aliyun.com/repository/jcenter' }
            maven { url 'http://maven.aliyun.com/nexus/content/groups/public' }
        }
    }

    repositories {
        mavenLocal()
        maven { url "https://maven.aliyun.com/repository/gradle-plugin" }
    }
}
```

## Android Studio下载

``` text
https://developer.android.google.cn/studio?hl=zh-cn
```

解压安装，下载Android SDK和模拟器镜像等。

安装Dart和Flutter插件。

## ~/.bashrc配置

``` text
PATH="flutter/sdk/bin:android/studio/bin:$PATH"
export PATH

FLUTTER_STORAGE_BASE_URL="https://mirrors.tuna.tsinghua.edu.cn/flutter"
PUB_HOSTED_URL="https://mirrors.tuna.tsinghua.edu.cn/dart-pub"
export FLUTTER_STORAGE_BASE_URL
export PUB_HOSTED_URL

ANDROID_SDK_ROOT="android/sdk"
export ANDROID_SDK_ROOT
```

```flutter/bin```、```android/studio/bin```和```android/sdk```对应实际的路径。

``` shell
source ~/.bashrc
```

应用配置。

## Flutter诊断

``` shell
flutter doctor
```
