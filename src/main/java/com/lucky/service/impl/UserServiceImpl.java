package com.lucky.service.impl;

import com.lucky.dao.UserDao;
import com.lucky.domain.User;
import com.lucky.exception.GlobalException;
import com.lucky.redis.RedisService;
import com.lucky.redis.UserKey;
import com.lucky.result.CodeMsg;
import com.lucky.service.UserService;
import com.lucky.util.MD5Util;
import com.lucky.util.UUIDUtil;
import com.lucky.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xiaoran
 * @date 2019/04/28
 */
@Service
public class UserServiceImpl implements UserService {
    public static final String COOKI_NAME_TOKEN = "token";

    @Autowired
    UserDao userDao;

    @Autowired
    RedisService redisService;

    /**
     * 登录,并为其生成session
     *
     * @param loginVo
     * @param response
     * @return
     */
    @Override
    public boolean login(LoginVo loginVo, HttpServletResponse response) {
        if (loginVo == null) {
            throw new GlobalException(CodeMsg.SERVER_EXCEPTION);
        }
        String mobile = loginVo.getMobile();
        String formPass = loginVo.getPassword();
        //判断手机号是否存在
        User user = getById(Long.parseLong(mobile));
        if (user == null) {
            throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }
        //验证密码
        String dbPass = user.getPassword();
        String saltDB = user.getSalt();
        String calcPass = MD5Util.formToDbPass(formPass, saltDB);
        if (!calcPass.equals(dbPass)) {
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }
        //生成cookie
        String token = UUIDUtil.uuid();
        addCookie(response, token, user);
        return true;
    }

    /**
     * 根据id获取user信息
     *
     * @param id
     * @return
     */
    public User getById(long id) {
        return userDao.getById(id);
    }

    /**
     * 1.将token存入redis
     * 2.将cookie存入reponse，返回给前端
     *
     * @param response
     * @param token
     * @param user
     */
    private void addCookie(HttpServletResponse response, String token, User user) {
        redisService.set(UserKey.token, token, user);
        Cookie cookie = new Cookie(COOKI_NAME_TOKEN, token);
        cookie.setMaxAge(UserKey.token.expireSeconds());
        cookie.setPath("/");
        response.addCookie(cookie);
    }

}
