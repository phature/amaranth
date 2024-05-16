# 嵌套虚拟化

## 配置嵌套虚拟化

``` PowerShell
Set-VMProcessor -VMName <VMName> -ExposeVirtualizationExtensions $true
```

## MAC 地址欺骗

``` PowerShell
Get-VMNetworkAdapter -VMName <VMName> | Set-VMNetworkAdapter -MacAddressSpoofing On
```
