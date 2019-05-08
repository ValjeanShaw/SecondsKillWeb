package com.lucky.vo;

import com.lucky.domain.Goods;
import lombok.Data;

import java.util.Date;

/**
 * 用于商品列表页面的controller 入参实体
 *
 * @author: xiaoran
 * @date: 2019-05-08 21:34
 */
@Data
public class GoodsVo extends Goods {

    private Double miaoshaPrice;

    private Integer stockCount;

    private Date startDate;

    private Date endDate;
}
