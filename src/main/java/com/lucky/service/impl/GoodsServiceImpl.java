package com.lucky.service.impl;


import com.lucky.dao.GoodsDao;
import com.lucky.service.GoodsService;
import com.lucky.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GoodsServiceImpl implements GoodsService {
	
	@Autowired
	GoodsDao goodsDao;

	@Override
	public List<GoodsVo> listGoodsVo(){
		return goodsDao.listGoodsVo();
	}

	@Override
	public GoodsVo getGoodsVoByGoodsId(long goodsId) {
		return goodsDao.getGoodsVoByGoodsId(goodsId);
	}

}
