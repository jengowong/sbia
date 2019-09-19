# 虚拟机性能监控与故障处理工具(Java命令学习系列1)

> https://mp.weixin.qq.com/s/KYZI-uQdLE7mZnVOgq4b1g

### [jps](https://mp.weixin.qq.com/s/fJP-o0Hzufu3pu9jSyF8Ow)
1. JVM Process Status Tool
2. 功能：
    - 显示当前系统的Java进程情况，及其id号。
    - 注意：仅查找当前用户的Java进程，而不是当前系统中的所有进程。
3. 实现机制：
    - Java程序在启动以后，会在`java.io.tmpdir`指定的目录下，就是临时文件夹里，生成一个类似于`hsperfdata_User`的文件夹，这个文件夹里(在Linux中为`/tmp/hsperfdata_{userName}/`}，有几个文件，名字就是java进程的pid。
    - 因此列出当前运行的java进程，只是把这个目录里的文件名列一下而已。至于系统的参数什么，就可以解析这几个文件获得。
4. 使用：
    - `-help` 查看帮助
    - `-q` 只显示pid，不显示class名称、jar文件名、传递给main方法的参数
    - `-m` 输出传递给main方法的参数，在嵌入式jvm上可能是null
    - `-l` 输出应用程序main class的完整package名 或者 应用程序的jar文件完整路径名
    - `-v` 输出传递给JVM的参数
5. jps失效处理：
        - jps、jconsole、jvisualvm等工具的数据来源就是这个文件`/tmp/hsperfdata_{serName}/pid`，所以当该文件不存在或是无法读取时就会出现jps无法查看该进程号，jconsole无法监控等问题。
