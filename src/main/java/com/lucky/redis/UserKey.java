package com.lucky.redis;

/**
 * @author: xiaoran
 * @date: 2019-04-20 19:51
 */
public class UserKey extends BasePrefix {
    private UserKey(String prefix) {
        super(prefix);
    }

    public UserKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static UserKey getById = new UserKey(1,"id-");
    public static UserKey getByName = new UserKey("name-");
}
