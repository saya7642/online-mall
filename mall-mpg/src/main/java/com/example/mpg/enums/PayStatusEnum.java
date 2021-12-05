
package com.example.mpg.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.ToString;

/**
 * @apiNote 订单状态:0.支付中 1.支付成功 -1.支付失败
 */
@ToString
public enum PayStatusEnum implements Enumerator {

    DEFAULT(-1, "支付失败"),
    PAY_ING(0, "支付中"),
    PAY_SUCCESS(1, "支付成功");

    @EnumValue
    private final int status;
    private final String name;

    PayStatusEnum(int status, String name) {
        this.status = status;
        this.name = name;
    }

    @JsonCreator
    public static PayStatusEnum resolve(int status) {
        for (PayStatusEnum payStatus : values()) {
            if (payStatus.status == status) {
                return payStatus;
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
