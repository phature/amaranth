# 用openssl生成HTTPS证书

## 创建相关目录和文件

``` shell
sudo mkdir /etc/pki/CA
cd /etc/pki/CA
sudo mkdir certs crl newcerts private server

sudo touch index.txt
echo 01 | sudo tee serial
```

## 创建CA机构密钥和证书

``` shell
sudo openssl genrsa -out private/cakey.pem 2048
sudo openssl req -new -x509 -days 4096 -key private/cakey.pem -out cacert.pem
```

## 创建服务器密钥和证书请求

``` shell
sudo openssl genrsa -out server/server.key 2048
sudo openssl req -new -key server/server.key -out server/server.csr
```

## 使用CA证书进行签名

``` shell
sudo openssl ca -days 4096 -cert cacert.pem -in server/server.csr -out certs/server.crt
```

## 导出PKCS12证书

``` shell
sudo openssl pkcs12 -export -chain -CAfile cacert.pem -name name -inkey server/server.key -in certs/server.crt -out server/server.p12
```
