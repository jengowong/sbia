package com.github.jengo.redisdemo;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * {@link RedisClient}
 */
public class RedisClient {

    private Socket socket;
    private OutputStream outputStream;
    private InputStream inputStream;

    public RedisClient(String host, int port) {
        try {
            this.socket = new Socket(host, port);
            this.outputStream = this.socket.getOutputStream();
            this.inputStream = this.socket.getInputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String set(String key, String value) {
        StringBuilder sb = new StringBuilder();
        //虽然输出的时候，会被转义，然而我们传送的时候还是要带上
        sb.append("*3").append("\r\n");
        sb.append("$3").append("\r\n");
        sb.append("SET").append("\r\n");
        sb.append("$").append(key.length()).append("\r\n");
        sb.append(key).append("\r\n");
        sb.append("$").append(value.length()).append("\r\n");
        sb.append(value).append("\r\n");
        byte[] bytes = new byte[1024];
        try {
            outputStream.write(sb.toString().getBytes());
            inputStream.read(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(bytes);
    }

    public static void main(String[] args) {
        RedisClient redisClient = new RedisClient("127.0.0.1", 6379);
        String result = redisClient.set("eat", "please eat");
        System.out.println(result);
    }

}
