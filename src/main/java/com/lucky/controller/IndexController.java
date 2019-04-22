package com.lucky.controller;

import com.lucky.redis.RedisService;
import com.lucky.redis.UserKey;
import com.lucky.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: xiaoran
 * @date: 2019-04-20 15:21
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    RedisService redisService;

    @RequestMapping("/hello")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "127.0.0.1");
        return "index";
    }

    @RequestMapping("/redis/setandget")
    @ResponseBody
    public Result testRedisSetAndGet() {
        boolean flag = redisService.set("key1", "hello redis");
        String value = redisService.get("key1", String.class);
        return Result.getSuccess(value);
    }

    @RequestMapping("/redis/setandgetprefix")
    @ResponseBody
    public Result testRedisSetAndGetPrefix() {
        boolean flag = redisService.set(UserKey.getById,"2", "hello redis");
        try{
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        String value = redisService.get(UserKey.getById,"2", String.class);
        return Result.getSuccess(value);
    }
}
