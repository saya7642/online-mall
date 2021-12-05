package com.example.mpg.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 枚举接口
 */
public interface Enumerator {

    /**
     * 获取枚举码值
     * 序列化和存入数据库时采用该值
     *
     * @return 枚举码
     */
    @JsonValue
    Integer code();

    /**
     * 枚举描述
     *
     * @return 描述
     */
    String desc();


}
