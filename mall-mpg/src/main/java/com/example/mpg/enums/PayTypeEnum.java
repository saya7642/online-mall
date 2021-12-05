
package com.example.mpg.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.ToString;

/**
 * @apiNote 订单状态:0.无 1.支付宝 2.微信支付
 */
@ToString
public enum PayTypeEnum implements Enumerator{

    DEFAULT(-1, "ERROR"),
    NOT_PAY(0, "无"),
    ALI_PAY(1, "支付宝"),
    WEIXIN_PAY(2, "微信支付");

    @EnumValue
    private final int type;
    private final String name;

    PayTypeEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }

    @JsonCreator
    public static PayTypeEnum resolve(int type) {
        for (PayTypeEnum payType : values()) {
            if (payType.type == type) {
                return payType;
            }
        }
        return DEFAULT;
    }

    public boolean matches(int type) {
        return (this == resolve(type));
    }

    @Override
    public Integer code() {
        return type;
    }

    @Override
    public String desc() {
        return name;
    }
}
