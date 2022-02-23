# JDK命令

## java

``` shell
java -XX:+HeapDumpOnOutOfMemoryError -XX:MaxHeapSize=1g -jar demo-0.0.1-SNAPSHOT.jar
```

-XX:+HeapDumpOnOutOfMemoryError内存溢出时生成转储文件。

-XX:MaxHeapSize=1g设置堆最大大小为1GB，为了避免压缩指针失效，该值要小于32GB。

## jps

``` shell
jps -mlvV
```

jps可以查看所有运行的JAVA进程，最前面的数字是进程ID。

## jinfo

``` shell
jinfo [PID]
```

jinfo可以查看JAVA进程的标识值和系统属性值。

## jstack

``` shell
jstack [PID]
```

jstack可以查看JAVA进程的线程状态。

## jmap

``` shell
jmap -dump:file=[FILE.hprof] [PID]
```

jmap可以转储JAVA进程的堆内存到文件·。

## jcmd

``` shell
jcmd
```

jcmd类似于jps。

``` shell
jcmd [PID] help
```

jcmd还可以执行一些命令：

VM.flags和VM.system_properties相当于jinfo。

Thread.print相当于jstack。

GC.class_stats、GC.class_histogram和GC.heap_dump相当于jmap。

## jstat

``` shell
jstat -gc [PID] 1000 16
```

对gc选项进行监控，间隔1000毫秒，采样16次。
