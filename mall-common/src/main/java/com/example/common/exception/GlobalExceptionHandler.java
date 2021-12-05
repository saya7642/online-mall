package com.example.common.exception;

import com.example.common.api.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 * Created by admin on 2021/10/01.
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ApiException.class)
    public R handle(ApiException e) {
        if (e.getResult() != null) {
            return R.failed(e.getResult());
        }
        return R.failed(e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public R handleException(Exception e) {
        log.error("errorMessage: {}", e.getMessage());
        return R.failed("系统繁忙，请稍后重试");
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleValidException(MethodArgumentNotValidException e) {
        return handleBindingResult(e.getBindingResult());
    }

    @ExceptionHandler(value = BindException.class)
    public R handleValidException(BindException e) {
        return handleBindingResult(e.getBindingResult());
    }

    private R handleBindingResult(BindingResult bindingResult) {
        String message = null;

        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            if (fieldError != null) {
                message = fieldError.getField() + fieldError.getDefaultMessage();
            }
        }

        return R.validateFailed(message);
    }
}
