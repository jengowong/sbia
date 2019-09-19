# 虚拟机性能监控与故障处理工具(Java命令学习系列2)

> https://mp.weixin.qq.com/s/KYZI-uQdLE7mZnVOgq4b1g

## [jstack](https://mp.weixin.qq.com/s/jE0c2KGwAPXToLMDyhT1eg)
1. 功能
    + 生成java虚拟机当前时刻的`线程快照`。
        - `线程快照`是当前java虚拟机内每一条线程正在执行的方法堆栈的集合。
        - 生成`线程快照`的主要目的是定位线程出现长时间停顿的原因，如线程间死锁、死循环、请求外部资源导致的长时间等待等。
        - 如果java程序崩溃生成`core文件`，jstack工具可以用来获得`core文件`的java stack和native stack的信息。
        - jstack工具还可以附属到正在运行的java程序中。
        - 看到当时运行的java程序的java stack和native stack的信息, 如果现在运行的java程序呈现hung的状态，jstack是非常有用的。
    1. 线程状态
        
    2. Monitor
    3. 调用修饰
    4. 线程动作

2. 线程dump分析
    1. 原则
    2. 入手点
    3. 入手点总结

3. 使用
    `- help / -h` 查看帮助
    `- l` long list
    `- F` force
    `- m` mix mode

    1. 死锁分析
    2. 其它