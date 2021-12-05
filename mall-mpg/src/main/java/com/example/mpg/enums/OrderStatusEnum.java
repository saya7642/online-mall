
package com.example.mpg.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.ToString;

/**
* @apiNote 订单状态:0.待支付 1.已支付 2.配货完成 3:出库成功 4.交易成功 -1.手动关闭 -2.超时关闭 -3.商家关闭
 */
@ToString
public enum OrderStatusEnum implements Enumerator {

    DEFAULT(-9, "ERROR"),
    ORDER_PRE_PAY(0, "待支付"),
    ORDER_PAID(1, "已支付"),
    ORDER_PACKAGED(2, "配货完成"),
    ORDER_EXPRESS(3, "出库成功"),
    ORDER_SUCCESS(4, "交易成功"),
    ORDER_CLOSED_BY_USER(-1, "手动关闭"),
    ORDER_CLOSED_BY_EXPIRED(-2, "超时关闭"),
    ORDER_CLOSED_BY_JUDGE(-3, "商家关闭");

    @EnumValue
    private final int status;
    private final String name;

    OrderStatusEnum(int status, String name) {
        this.status = status;
        this.name = name;
    }

    @JsonCreator
    public static OrderStatusEnum resolve(int status) {
        for (OrderStatusEnum orderStatus : values()) {
            if (orderStatus.status == status) {
                return orderStatus;
            }
        }
        return DEFAULT;
    }

    public boolean matches(int status) {
        return (this == resolve(status));
    }


    @Override
    public Integer code() {
        return status;
    }

    @Override
    public String desc() {
        return name;
    }

}
