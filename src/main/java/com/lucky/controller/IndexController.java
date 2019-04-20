package com.lucky.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: xiaoran
 * @date: 2019-04-20 15:21
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/hello")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "127.0.0.1");
        return "index";
    }
}
