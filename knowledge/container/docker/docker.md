# Docker是什么

容器类似于操作系统运行环境，可以在环境里运行各种各样的应用。容器的优点在于它和宿主系统是隔离的，应用不需要依赖宿主系统的环境、类库支持等等一致的运行在容器中，相对于虚拟机而言它是轻量级的。

容器技术是基于Linux内核的LXC技术，所以容器需要运行在Linux操作系统上，如果需要在Windows上面运行容器，docker的做法是启用Hyper-V虚拟机，在上面运行一个Tiny Linux系统来支持容器运行。

[容器](./docker/container.png)

[虚拟机](./docker/virtual-machine.png)

容器和虚拟机运行应用对比示意图。

docker是容器的一种实现。
