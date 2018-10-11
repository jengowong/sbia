package com.github.jengo.redisdemo;

import redis.clients.jedis.Jedis;

/**
 * {@link RedisTest}
 */
public class RedisTest {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.set("eat", "I want to eat");
        jedis.close();
    }

}
