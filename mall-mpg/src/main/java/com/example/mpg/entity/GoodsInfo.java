package com.example.mpg.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author admin
 * @since 2021-11-08
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("t_goods_info")
public class GoodsInfo extends Model<GoodsInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 商品表主键id
     */
    @TableId(value = "goods_id", type = IdType.AUTO)
    private Long goodsId;

    /**
     * 商品名
     */
    private String goodsName;

    /**
     * 商品简介
     */
    private String goodsIntro;

    /**
     * 关联分类id
     */
    private Long goodsCategoryId;

    /**
     * 商品主图
     */
    private String goodsCoverImg;

    /**
     * 商品轮播图
     */
    private String goodsCarousel;

    /**
     * 商品详情
     */
    private String goodsDetailContent;

    /**
     * 商品价格
     */
    private Integer originalPrice;

    /**
     * 商品实际售价
     */
    private Integer sellingPrice;

    /**
     * 商品库存数量
     */
    private Integer stockNum;

    /**
     * 商品标签
     */
    private String tag;

    /**
     * 商品上架状态 0-下架 1-上架
     */
    private Integer goodsSellStatus;

    /**
     * 添加者主键id
     */
    private Integer createUser;

    /**
     * 商品添加时间
     */
    private LocalDateTime createTime;

    /**
     * 修改者主键id
     */
    private Integer updateUser;

    /**
     * 商品修改时间
     */
    private LocalDateTime updateTime;


    @Override
    public Serializable pkVal() {
        return this.goodsId;
    }

}
