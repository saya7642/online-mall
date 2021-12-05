package com.example.mpg.base;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public abstract class BaseController {

    protected HttpServletRequest getRequest() {
        ServletRequestAttributes attr = getRequestAttributes();
        if (attr == null) {
            throw new IllegalStateException("当前线程中不存在 Request 上下文");
        }
        return attr.getRequest();
    }

    protected HttpServletResponse getResponse() {
        ServletRequestAttributes attr = getRequestAttributes();
        if (attr == null) {
            throw new IllegalStateException("当前线程中不存在 Response 上下文");
        }
        return attr.getResponse();
    }

    protected ServletRequestAttributes getRequestAttributes() {
        return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    }
}
