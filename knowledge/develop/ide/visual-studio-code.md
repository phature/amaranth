# Visual Studio Code

## 中文界面插件安装

作者：Microsoft

插件：Chinese (Simplified) Language Pack for Visual Studio Code

## Vue.js插件安装

作者：Pine Wu

插件：Vetur

## ESLint插件安装

作者：Dirk Baeumer

插件：ESLint

## ESLint插件settings.json配置

``` text
    //ESLint begin
    "eslint.autoFixOnSave": true,
    "eslint.alwaysShowStatus": true,
    "eslint.validate": [
        "javascript",
        "javascriptreact",
        {
            "language": "html",
            "autoFix": true
        },
        {
            "language": "vue",
            "autoFix": true
        }
    ]
    //ESLint end
```
