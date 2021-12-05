package com.example.mpg.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
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
@TableName("t_shopping_cart_item")
public class ShoppingCartItem extends Model<ShoppingCartItem> {

    private static final long serialVersionUID = 1L;

    /**
     * 购物项主键id
     */
    @TableId(value = "cart_item_id", type = IdType.AUTO)
    private Long cartItemId;

    /**
     * 用户主键id
     */
    private Long userId;

    /**
     * 关联商品id
     */
    private Long goodsId;

    /**
     * 数量(最大为5)
     */
    private Integer goodsCount;

    /**
     * 删除标识字段(0-未删除 1-已删除)
     */
    @TableLogic
    private Integer isDeleted;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 最新修改时间
     */
    private LocalDateTime updateTime;


    @Override
    public Serializable pkVal() {
        return this.cartItemId;
    }

}
