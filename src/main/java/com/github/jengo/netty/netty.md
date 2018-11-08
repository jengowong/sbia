## netty
[link](http://tutorials.jenkov.com/netty/index.html)

------

### Netty Overview
In order to understand how Netty works it is useful to get an overview of Netty's internal design. 
There are several central concepts you need to know about. These are:

Bootstrap : bootstrapping process includes starting threads, opening sockets etc
    |
    v
EventLoopGroup : a group of EventLoop'S, EventLoop shares some resources like threads etc
    |
    v
EventLoop : a loop that keeps looking for new events, when an event occurs, the event is passed on to the appropriate event handler,
    |
    V
SocketChannel : represents a TCP connection to another computer over a network, A SocketChannel is managed by a same EventLoop
    | 
    | --> ChannelInitializer : a special ChannelHandler which is attached to the ChannelPipeline of a SocketChannel when the SocketChannel is created
    |
    V
ChannelPipeline : Each Netty SocketChannel has a ChannelPipeline. The ChannelPipeline contains a list of ChannelHandler instances.
    |
    V
ChannelHandler : handles the data that is received from or written out to a Netty SocketChannel