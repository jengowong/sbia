package com.github.jengo.redisdemo;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * {@link SocketServer}
 *
 * https://mp.weixin.qq.com/s/UhX8J9v01bMCDQrNHkoY4A
 */
public class SocketServer {

    public static void main(String[] args) throws Exception {
        System.out.println("SocketServer starting ...");
        ServerSocket server = new ServerSocket(6379);
        Socket socket = server.accept();
        byte[] chars = new byte[64];
        socket.getInputStream().read(chars);
        System.out.println(new String(chars));
        socket.getOutputStream().write("OK".getBytes());
        System.out.println("SocketServer stopped .");
    }

}
