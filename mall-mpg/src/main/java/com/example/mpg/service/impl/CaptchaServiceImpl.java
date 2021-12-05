package com.example.mpg.service.impl;

import com.example.common.constant.CacheKey;
import com.example.common.exception.Assert;
import com.example.common.util.RedisUtils;
import com.example.mpg.service.CaptchaService;
import com.wf.captcha.ArithmeticCaptcha;
import com.wf.captcha.base.Captcha;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

@Service
public class CaptchaServiceImpl implements CaptchaService {

    @Resource
    private RedisUtils redisUtils;

    @Override
    public void createCaptcha(String key, OutputStream outputStream) {
        Assert.notBlank(key, "验证码key不能为空");
        Captcha captcha = new ArithmeticCaptcha(115, 42);
        captcha.setCharType(2);
        captcha.out(outputStream);
        key = CacheKey.build(CacheKey.CAPTCHA, key);
        redisUtils.set(key, captcha.text());
    }

    @Override
    public void check(String key, String code) {
        key = CacheKey.build(CacheKey.CAPTCHA, key);
        String captcha = redisUtils.get(key, String.class);
        Assert.notNull(captcha, "验证码已过期");
        Assert.isTrue(captcha.equalsIgnoreCase(code), "验证码不正确");
        redisUtils.del(CacheKey.CAPTCHA, key);
    }

    /**
     * 设置响应头
     *
     * @param response HttpServletResponse
     */
    @Override
    public void setCaptchaHeader(HttpServletResponse response) {
        response.setContentType("image/png");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
    }
}
