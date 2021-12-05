package com.example.mpg.enums;


import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.ToString;

/**
 * @apiNote 首页配置项
 */
@ToString
public enum IndexConfigTypeEnum implements Enumerator {

    /**
     * 默认，无
     */
    DEFAULT(0),
    /**
     * 1-搜索框热搜
     */
    INDEX_SEARCH_HOTS(1),
    /**
     * 2-搜索下拉框热搜
     */
    INDEX_SEARCH_DOWN_HOTS(2),
    /**
     * 3-(首页)热销商品
     */
    INDEX_GOODS_HOT(3),
    /**
     * 4-(首页)新品上线
     */
    INDEX_GOODS_NEW(4),
    /**
     * 5-(首页)为你推荐
     */
    INDEX_GOODS_RECOMMEND(5);

    @EnumValue
    private final int type;

    IndexConfigTypeEnum(int type) {
        this.type = type;
    }

    @JsonCreator
    public static IndexConfigTypeEnum resolve(int type) {
        for (IndexConfigTypeEnum configType : values()) {
            if (configType.type == type) {
                return configType;
            }
        }
        return DEFAULT;
    }

    public boolean matches(int type) {
        return (this == resolve(type));
    }

    @Override
    public Integer code() {
        return this.type;
    }

    @Override
    public String desc() {
        return this.name();
    }
}
