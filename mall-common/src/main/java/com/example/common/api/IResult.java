package com.example.common.api;

/**
 * 常用API返回对象接口
 * Created by admin on 2021/10/01.
 */
public interface IResult {

    /**
     * 返回码
     */
    long getCode();

    /**
     * 返回信息
     */
    String getMessage();
}
