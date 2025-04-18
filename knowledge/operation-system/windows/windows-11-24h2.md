# Windows 11 24H2安装配置

## 跳过UEFI和TPM

安装界面打开命令提示符，打开注册表，在\HKEY_LOCAL_MACHINE\SYSTEM\Setup添加LabConfig项，并在项里面添加BypassSecureBootCheck、BypassTPMCheck两个32位DWORD键，值都为1。

```cmd
Shift+F10
regedit
```

```text
\HKEY_LOCAL_MACHINE\SYSTEM\Setup
+LabConfig [ITEM]
++BypassSecureBootCheck [REG_DWORD] 1
++BypassTPMCheck  [REG_DWORD] 1
```

## 分区注意

EFI分区未格式化会出错

## 跳过在线账号

```text
no@thankyou.com
```

```text
start ms-cxh:localonly
```

## 激活Administrator账号

```cmd
net user Administrator /active:yes
```

## 删除临时账户

注销临时账户，登录Administrator，删除临时账户。

## 常用操作

### 磁盘管理

### 安装驱动程序

### 系统更新


### 调整桌面视图


### 清理屏幕保护程序

```cmd
takeown /f c:\Windows\System32\*.scr
icacls c:\Windows\System32\*.scr /reset
del c:\Windows\System32\*.scr
```

```cmd
takeown /f c:\Windows\SysWOW64\*.scr
icacls c:\Windows\SysWOW64\*.scr /reset
del c:\Windows\SysWOW64\*.scr
```

### 清理背景图片

```cmd
takeown /f c:\Windows\Resources /r
icacls c:\Windows\Resources /reset /t
```

```cmd
takeown /f c:\Windows\Web /r
icacls c:\Windows\Web /reset /t
```

### 清理锁屏图片

```cmd
takeown /f c:\ProgramData\Microsoft\Windows\SystemData /r
icacls c:\ProgramData\Microsoft\Windows\SystemData /reset /t
```

### 调整资源管理器各类文件夹视图

### 创建开始菜单Application

## 调整设置

### 系统/系统信息/高级系统设置

#### 远程

#### 系统保护

#### 显示操作系统列表的时间

#### 写入调试信息

#### 性能

#### 虚拟内存

#### 计算机名

### 系统/电源和电池

```cmd
powercfg /h off
```

### 蓝牙和其他设备/自动播放

### 个性化/开始

### 个性化/任务栏

### 应用/安装的应用

### 应用/启动

### 时间和语言/语言和区域/增加语言

### 时间和语言/语言和区域/选项/微软拼音

### 辅助功能/鼠标指针与触控

### 隐私和安全性/活动历史记录

### Windows 更新

## 任务栏右下角弹窗快捷方式调整

## 配置应用固定到开始屏幕

## 主文件夹

### 用户目录

```text
C:\Users\Administrator
```

### PowerShell PSReadLine目录

```text
C:\Users\Administrator\AppData\Roaming\Microsoft\Windows\PowerShell\PSReadLine
```

### 锁屏聚焦应用目录

```text
C:\Users\Administrator\AppData\Local\Packages\Microsoft.Windows.ContentDeliveryManager_cw5n1h2txyewy
C:\Users\Administrator\AppData\Local\Packages\MicrosoftWindows.Client.CBS_cw5n1h2txyewy
```


## 脚本

### 恢复右键菜单全部显示

```cmd
REG ADD "HKEY_CURRENT_USER\Software\Classes\CLSID\{86ca1aa0-34aa-4e8b-a509-50c905bae2a2}\InprocServer32" /ve
```

### 删除网络配置


```cmd
REG DELETE "HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Windows NT\CurrentVersion\NetworkList\Profiles" /f
REG DELETE "HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Windows NT\CurrentVersion\NetworkList\Signatures\Unmanaged" /f
```

### PowerShell的PSReadLine不记录历史

C:\Users\Administrator\Documents\WindowsPowerShell\Microsoft.PowerShell_profile.ps1

```PowerShell
Set-PSReadLineOption -HistorySaveStyle SaveNothing
```
