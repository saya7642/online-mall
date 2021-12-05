
package com.example.mpg.enums;


import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.ToString;

/**
 * @apiNote 分类级别
 */
@ToString
public enum CategoryLevelEnum implements Enumerator {

    DEFAULT(0, "ERROR"),
    LEVEL_ONE(1, "一级分类"),
    LEVEL_TWO(2, "二级分类"),
    LEVEL_THREE(3, "三级分类");

    @EnumValue
    private final int level;
    private final String name;

    CategoryLevelEnum(int level, String name) {
        this.level = level;
        this.name = name;
    }

    @JsonCreator
    public static CategoryLevelEnum resolve(int level) {
        for (CategoryLevelEnum categoryLevel : values()) {
            if (categoryLevel.level == level) {
                return categoryLevel;
            }
        }
        return DEFAULT;
    }


    public boolean matches(int level) {
        return (this == resolve(level));
    }

    @Override
    public Integer code() {
        return level;
    }

    @Override
    public String desc() {
        return name;
    }

}
