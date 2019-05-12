package com.lucky.service.impl;

import com.lucky.domain.OrderInfo;
import com.lucky.domain.User;
import com.lucky.service.GoodsService;
import com.lucky.service.MiaoshaService;
import com.lucky.service.OrderService;
import com.lucky.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MiaoshaServiceImpl implements MiaoshaService {
	
	@Autowired
	GoodsService goodsService;
	
	@Autowired
	OrderService orderService;

	@Override
	@Transactional
	public OrderInfo miaosha(User user, GoodsVo goods) {
		//减库存 下订单 写入秒杀订单
		goodsService.reduceStock(goods);
		//order_info maiosha_order
		return orderService.createOrder(user, goods);
	}
	
}
