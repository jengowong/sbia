# 虚拟机性能监控与故障处理工具(Java命令学习系列4)

> https://mp.weixin.qq.com/s/KYZI-uQdLE7mZnVOgq4b1g

### [jstat](https://mp.weixin.qq.com/s/pp0hrFPguptR4Q68wQRzDQ)
1. JVM Statistics Monitoring Tool
2. 功能：
    - 用于监控虚拟机各种运行状态信息，他可以显示`本地`或`远程`虚拟机进程中的类装载、内存、垃圾收集、JIT编译等`运行`数据。
    - jstat是轻量级的、专门针对JVM的工具，在没有GUI图形的服务器上，它是运行期定位虚拟机性能问题的首选工具。
3. 命令格式：
    - `jstat [ generalOption | outputOptions vmid [ interval[s|ms] [ count ] ]`
4. generalOption:
    - `-help`
    - `-options`
5. outputOptions：
    + statOption:代表用户希望查询的虚拟机信息，主要分为3类：`类装载`、`垃圾收集`和`运行期编译状况`。
        - `–class` 监视类装载、卸载数量、总空间及类装载所耗费的时间。
        - `-compiler` 输出JIT编译器编译过的方法、耗时等信息。
        - `-gc` 监视Java堆状况，包括Eden区、2个Survivor区、老年代、永久代等的容量。
        - `-gccapacity` 监视内容与`-gc`基本相同，但输出主要关注Java堆各个区域使用到的最大和最小空间。
        - `-gcutil` 监视内容与`-gc`基本相同，但输出主要关注已使用空间占总空间的百分比。
        - `-gcnew` 监视新生代GC的状况。
        - `-gcnewcapacity` 监视内容与`-gcnew`基本相同，输出主要关注使用到的最大和最小空间。
        - `-gcold` 监视老年代GC的状况。
        - `-gcoldcapacity` 监视内容与`-gcold`基本相同，输出主要关注使用到的最大和最小空间。
        - `-printcompilation` 输出已经被JIT编译的方法。
    + 