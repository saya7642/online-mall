package com.example.mpg.service;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

public interface CaptchaService {

    void createCaptcha(String key, OutputStream out);

    void check(String key, String code);

    void setCaptchaHeader(HttpServletResponse response);
}
