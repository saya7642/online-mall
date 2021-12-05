package com.example.common.exception;


import cn.hutool.core.util.StrUtil;
import com.example.common.api.IResult;

/**
 * 断言处理类，用于抛出各种API异常
 * Created by admin on 2021/10/01.
 */
public abstract class Assert {

    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IResult result) {
        throw new ApiException(result);
    }

    public static void isTrue(boolean expression, String message) {
        if(!expression) {
            throw new ApiException(message);
        }
    }

    public static void isTrue(boolean expression, IResult result) {
        if(!expression) {
            throw new ApiException(result);
        }
    }

    public static void notNull(Object obj, String message) {
        if(obj == null) {
            throw new ApiException(message);
        }
    }

    public static void notNull(Object obj, IResult result) {
        if(obj == null) {
            throw new ApiException(result);
        }
    }

    public static void notBlank(String text, String message) {
        if(StrUtil.isBlank(text)) {
            throw new ApiException(message);
        }
    }
}
