package com.example.common.exception;


import com.example.common.api.IResult;

/**
 * 自定义API异常
 * Created by admin on 2021/10/01.
 */
public class ApiException extends RuntimeException {
    private IResult resultCode;

    public ApiException(IResult resultCode) {
        super(resultCode.getMessage());
        this.resultCode = resultCode;
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public IResult getResultCode() {
        return resultCode;
    }
}
