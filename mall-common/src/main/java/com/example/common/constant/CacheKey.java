package com.example.common.constant;

import cn.hutool.core.text.StrPool;
import cn.hutool.core.util.StrUtil;

public interface CacheKey {

    /**
     * 缓存验证码key
     */
    String CAPTCHA = "captcha";

    /**
     * 缓存user的key
     */
    String USER_KEY = "mall_user";

    /**
     * 缓存admin的key
     */
    String ADMIN_KEY = "mall_admin";

    /**
     * 分隔符
     */
    String split = StrPool.COLON;

    /**
     * 构建key
     */
    static String build(Object... args) {
        if (args.length == 1) {
            return String.valueOf(args[0]);
        } else if (args.length > 0) {
            return StrUtil.join(split, args);
        } else {
            throw new IllegalArgumentException("缓存key不能为空");
        }
    }
}
