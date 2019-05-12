package com.lucky.service;

import com.lucky.domain.OrderInfo;
import com.lucky.domain.User;
import com.lucky.vo.GoodsVo;

/**
 * @author xiaoran
 * @date 2019/05/12
 */
public interface MiaoshaService {

    public OrderInfo miaosha(User user, GoodsVo goods);
}
