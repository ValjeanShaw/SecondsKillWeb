package com.lucky.dao;


import com.lucky.domain.MiaoshaGoods;
import com.lucky.vo.GoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component
public interface GoodsDao {

	/**
	 * 查询所有商品
	 * @return
	 */
	@Select("select g.*,mg.stock_count, mg.start_date, mg.end_date,mg.miaosha_price from miaosha_goods mg left join goods g on mg.goods_id = g.id")
	List<GoodsVo> listGoodsVo();

	/**
	 * 按照商品id查询所有商品
	 * @param goodsId
	 * @return
	 */
	@Select("select g.*,mg.stock_count, mg.start_date, mg.end_date,mg.miaosha_price from miaosha_goods mg left join goods g on mg.goods_id = g.id where g.id = #{goodsId}")
	public GoodsVo getGoodsVoByGoodsId(@Param("goodsId")long goodsId);

	/**
	 * 减少一件库存
	 * @param g
	 * @return
	 */
	@Update("update miaosha_goods set stock_count = stock_count - 1 where goods_id = #{goodsId}")
	public int reduceStock(MiaoshaGoods g);
}
