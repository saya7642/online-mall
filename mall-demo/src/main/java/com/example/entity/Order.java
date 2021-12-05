package com.example.entity;

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
 * @since 2021-11-23
 */
@Getter
@Setter
  @Accessors(chain = true)
  @TableName("t_order")
public class Order extends Model<Order> {

    private static final long serialVersionUID = 1L;

      /**
     * 订单表主键id
     */
        @TableId(value = "order_id", type = IdType.AUTO)
      private Long orderId;

      /**
     * 订单号
     */
      private String orderNo;

      /**
     * 用户主键id
     */
      private Long userId;

      /**
     * 订单总价
     */
      private Integer totalPrice;

      /**
     * 支付状态:0.未支付,1.支付成功,-1:支付失败
     */
      private Integer payStatus;

      /**
     * 0.无 1.支付宝支付 2.微信支付
     */
      private Integer payType;

      /**
     * 支付时间
     */
      private LocalDateTime payTime;

      /**
     * 订单状态:0.待支付 1.已支付 2.配货完成 3:出库成功 4.交易成功 -1.手动关闭 -2.超时关闭 -3.商家关闭
     */
      private Integer orderStatus;

      /**
     * 订单body
     */
      private String extraInfo;

      /**
     * 收货人姓名
     */
      private String userName;

      /**
     * 收货人手机号
     */
      private String userPhone;

      /**
     * 收货人收货地址
     */
      private String userAddress;

      /**
     * 删除标识字段(0-未删除 1-已删除)
     */
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
          return this.orderId;
      }

}
