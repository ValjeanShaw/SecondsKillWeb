package com.lucky.controller;


import com.alibaba.fastjson.JSON;
import com.lucky.result.Result;
import com.lucky.vo.LoginVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {

    /**
     * 跳转到登录界面
     *
     * @return
     */
    @RequestMapping("/to_login")
    public String toLogin() {
        return "login";
    }


    @RequestMapping("/do_login")
    @ResponseBody
    public Result<Boolean> doLogin(@Valid LoginVo loginVo) {
        log.info("param: {}", JSON.toJSONString(loginVo));
        return Result.getSuccess(true);
    }

}
