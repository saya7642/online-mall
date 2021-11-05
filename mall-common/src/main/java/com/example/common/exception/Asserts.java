package com.example.common.exception;


import com.example.common.api.IResult;

/**
 * 断言处理类，用于抛出各种API异常
 * Created by admin on 2021/10/01.
 */
public class Asserts {

    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IResult resultCode) {
        throw new ApiException(resultCode);
    }
}
