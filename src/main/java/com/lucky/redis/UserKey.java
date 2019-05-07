package com.lucky.redis;

/**
 * @author: xiaoran
 * @date: 2019-04-20 19:51
 */
public class UserKey extends BasePrefix {
    public static final int TOKEN_EXPIRE = 3600*24 * 2;

    private UserKey(String prefix) {
        super(prefix);
    }

    public UserKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static UserKey getById = new UserKey(1, "id-");

    public static UserKey token = new UserKey(TOKEN_EXPIRE, "tk-");
}
