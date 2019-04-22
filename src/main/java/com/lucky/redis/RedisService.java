package com.lucky.redis;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * redis相关的服务操作,相当于redis的工具类
 * <p>
 * 使用fastjson和jedis实现redis对象的序列化
 *
 * @author: xiaoran
 * @date: 2019-04-20 17:42
 */
@Service
public class RedisService {

    @Autowired
    JedisPool jedisPool;

    /**
     * 按照key获取对应类型的value
     *
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T get(String key, Class<T> clazz) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String string = jedis.get(key);
            T t = stringToObj(string, clazz);
            return t;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 按照key获取对应类型的value  自动加模块前缀
     *
     * @param prefix
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T get(KeyPrefix prefix, String key, Class<T> clazz) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            if (prefix == null) {
                return null;
            }
            String string = jedis.get(prefix.getPrefix() + key);
            T t = stringToObj(string, clazz);
            return t;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 传参，string类型放入redis
     *
     * @param key
     * @param value
     * @param <T>
     * @return
     */
    public <T> boolean set(String key, T value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String valueStr = objToString(value);
            if (StringUtils.isBlank(valueStr)) {
                return false;
            }
            jedis.set(key, valueStr);
            return true;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }


    /**
     * 传参，string类型放入redis,自动加前缀
     * <p>
     * 并设置过期时间
     *
     * @param prefix
     * @param key
     * @param value
     * @param <T>
     * @return
     */
    public <T> boolean set(KeyPrefix prefix, String key, T value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String valueStr = objToString(value);
            if (StringUtils.isBlank(valueStr) && prefix == null) {
                return false;
            }
            int second = prefix.expireSeconds();
            if (second <= 0) {
                jedis.set(prefix.getPrefix() + key, valueStr);
            } else {
                jedis.setex(prefix.getPrefix() + key, second, valueStr);
            }
            return true;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 对象序列化为string类型
     *
     * @param value
     * @param <T>
     * @return
     */
    private <T> String objToString(T value) {
        if (value == null) {
            return null;
        }
        Class<?> clazz = value.getClass();
        if (clazz == int.class || clazz == Integer.class) {
            return "" + value;
        } else if (clazz == long.class || clazz == Long.class) {
            return "" + value;
        } else if (clazz == String.class) {
            return (String) value;
        } else {
            return JSON.toJSONString(value);
        }
    }

    /**
     * string反序列化为对象
     *
     * @param string
     * @param clazz
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    private <T> T stringToObj(String string, Class<T> clazz) {
        if (StringUtils.isBlank(string) || clazz == null) {
            return null;
        }
        if (clazz == int.class || clazz == Integer.class) {
            return (T) Integer.valueOf(string);
        } else if (clazz == long.class || clazz == Long.class) {
            return (T) Long.valueOf(string);
        } else if (clazz == String.class) {
            return (T) string;
        } else {
            return JSON.parseObject(string, clazz);
        }
    }


}
