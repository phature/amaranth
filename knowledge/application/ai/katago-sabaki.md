# 用katago和sabaki下围棋

## 下载相关软件

[KataGo](https://github.com/lightvector/KataGo)

kataGo有CPU版、AVX2指令的CPU版、CUDA版和OpenCL版。

[神经网络训练库](https://d3dndmfyhecmj0.cloudfront.net/g170/neuralnets/index.html)

[sabaki](https://sabaki.yichuanshen.de/)

## kataGo用神经网络库生成配置

``` shell
./katago-avx2/katago genconfig -model neuralnets/model.bin.gz -output katago-avx2/rule_gtp.cfg
```

## sabaki配置kataGo引擎

``` text
katago-rule
/minor/application/develop/go/katago-avx2/katago
gtp -model /application/go/neuralnets/model.bin.gz -config /application/go/katago-avx2/rule_gtp.cfg
time_settings 0 60 1
```

引擎名称。

引擎程序路径。

启动参数配置。

时间设置。延时、读秒、每次落子数。
