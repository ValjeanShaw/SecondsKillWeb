package com.lucky.redis;

/**
 * 前缀接口，模板模式
 *
 * @author: xiaoran
 * @date: 2019-04-20 19:39
 */
public interface KeyPrefix {
    /**
     * 有效期
     * @return
     */
    public int expireSeconds();

    /**
     * key名前缀
     * @return
     */
    public String getPrefix();
}
