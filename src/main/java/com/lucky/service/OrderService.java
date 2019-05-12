package com.lucky.service;

import com.lucky.domain.MiaoshaOrder;
import com.lucky.domain.OrderInfo;
import com.lucky.domain.User;
import com.lucky.vo.GoodsVo;

/**
 * @author xiaoran
 * @date 2019/05/12
 */
public interface OrderService {

    /**
     * 通过用户id和商品id查询秒杀订单
     * @param userId
     * @param goodsId
     * @return
     */
    public MiaoshaOrder getMiaoshaOrderByUserIdGoodsId(long userId, long goodsId);

    /**
     * 创建订单   常规订单入库和秒杀订单入库
     * @param user
     * @param goods
     * @return
     */
    public OrderInfo createOrder(User user, GoodsVo goods);
}
