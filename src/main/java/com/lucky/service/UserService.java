package com.lucky.service;

import com.lucky.domain.User;
import com.lucky.vo.LoginVo;

import javax.servlet.http.HttpServletResponse;

/**
 * @author xiaoran
 * @date 2019/04/28
 */
public interface UserService {

    boolean login(LoginVo loginVo, HttpServletResponse response);

    User getByToken(HttpServletResponse response, String token);
}
