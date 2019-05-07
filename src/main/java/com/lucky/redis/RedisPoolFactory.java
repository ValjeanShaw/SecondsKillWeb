package com.lucky.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * jedis连接池
 *
 * @author: xiaoran
 * @date: 2019-04-20 17:10
 */
@Component
public class RedisPoolFactory {

    @Autowired
    RedisConfig redisConfig;

    /**
     * 自定义一个jedis连接池
     *
     * @return
     */
    @Bean
    public JedisPool jedisPoolFactory() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(redisConfig.getPoolMaxTotal());
        poolConfig.setMaxIdle(redisConfig.getPoolMaxIdle());
        poolConfig.setMaxWaitMillis(redisConfig.getPoolMaxWait());
        JedisPool jedisPool = new JedisPool(poolConfig,
                redisConfig.getHost(), redisConfig.getPort(), redisConfig.getTimeout(), redisConfig.getPassword());
        return jedisPool;
    }

//    public static void main(String[] args) {
//        Jedis jedis = new Jedis("39.107.68.25",6969);
//        jedis.auth("j4nc9je0&y");
//        // 查看服务是否运行
//        System.out.println("Server is running: " + jedis.ping());
//    }

}
