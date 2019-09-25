package com.sschen.test;

import redis.clients.jedis.Jedis;

/**
 * Redis客户端连接测试
 * @author sschen
 * @date 2019-9-25 23:09:30
 */
public class JedisClient {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.202.130");
        System.out.println("连接成功");
        jedis.set("chenss","smart");
        System.out.println("redis中存储的字符串值为： " + jedis.get("chenss"));
    }
}
