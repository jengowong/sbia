# 虚拟机性能监控与故障处理工具(Java命令学习系列3)

> https://mp.weixin.qq.com/s/KYZI-uQdLE7mZnVOgq4b1g

### [jmap](https://mp.weixin.qq.com/s/Wh-KEQMexMN5_qcdbCIFog)
1. JVM 
2. 什么是堆Dump：
    - 堆Dump是反应Java堆使用情况的内存镜像，其中主要包括`系统信息`、`虚拟机属性`、`完整的线程Dump`、`所有类和对象的状态`等。
    - 一般在内存不足、GC异常等情况下，我们就会怀疑有内存泄露，这个时候我们就可以制作堆Dump来查看具体情况，分析原因。
3. 命令格式：
    + `jmap [option] <pid>`
        - (to connect to running process)
    + `jmap [option] <executable <core>`
        - (to connect to a core file)
    + `jmap [option] [server_id@]<remote server IP or hostname>`
        - (to connect to remote debug server)