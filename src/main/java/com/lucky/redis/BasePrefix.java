package com.lucky.redis;

/**
 * @author: xiaoran
 * @date: 2019-04-20 19:42
 */
public abstract class BasePrefix implements KeyPrefix {

    /**
     * 0代表永不过期
     */
    private int expireSeconds;

    private String prefix;

    public BasePrefix(String prefix) {
        this.expireSeconds = 0;
        this.prefix = prefix;
    }

    public BasePrefix(int expireSeconds, String prefix) {
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }

    @Override
    public int expireSeconds() {
        return expireSeconds;
    }

    /**
     * 为每个子类取类名和指定前缀  作为前缀
     *
     * @return
     */
    @Override
    public String getPrefix() {
        String className = getClass().getSimpleName();
        return className + ":" + prefix;
    }
}
