package com.example.common.util;


import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletUtils {

    public static ServletRequestAttributes getServletRequestAttributes() {
        return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    }

    public static HttpServletRequest getHttpServletRequest() {
        ServletRequestAttributes attributes = getServletRequestAttributes();
        if (attributes == null) {
            return null;
        }

        return attributes.getRequest();
    }

    public static HttpServletResponse getHttpServletResponse() {
        ServletRequestAttributes attributes = getServletRequestAttributes();
        if (attributes == null) {
            return null;
        }

        return attributes.getResponse();
    }
}
