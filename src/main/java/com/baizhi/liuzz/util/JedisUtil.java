package com.baizhi.liuzz.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by Administrator on 2017/11/3.
 */

/**
 *  Jedis 工具类
 */
public class JedisUtil {
    private static JedisPool jedisPool;

    static{
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(20);
        config.setMaxWaitMillis(5000);

        jedisPool = new JedisPool(config, "192.168.79.130", 6379);
    }

    public static Jedis getJedis(){
        Jedis jedis = jedisPool.getResource();
        return jedis;
    }
    public static void closeJedis(Jedis jedis){
           jedis.close();
    }

    public static void main(String[] args) {

        Jedis jedis = getJedis();

        jedis.select(0);

        jedis.setex("18511887794",90,"sdff");
    }

}
