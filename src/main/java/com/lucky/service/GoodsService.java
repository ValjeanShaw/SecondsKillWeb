package com.lucky.service;

import com.lucky.vo.GoodsVo;

import java.util.List;

/**
 * @author xiaoran
 * @date 2019/05/08
 */
public interface GoodsService {
    /**
     * 列出所有的商品
     * @return
     */
    public List<GoodsVo> listGoodsVo();

    /**
     * 按照商品的id展示商品详情
     * @param goodsId
     * @return
     */
    public GoodsVo getGoodsVoByGoodsId(long goodsId);

    /**
     * 减少一件库存
     * @param goods
     */
    public void reduceStock(GoodsVo goods);
}
