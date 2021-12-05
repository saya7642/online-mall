package com.example.mpg.service.impl;

import cn.hutool.core.util.CharsetUtil;
import com.example.common.exception.Assert;
import com.example.mpg.entity.User;
import com.example.mpg.mapper.UserMapper;
import com.example.mpg.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mpg.util.MD5Util;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2021-11-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User login(String username, String password) {
        User user = lambdaQuery()
                .eq(User::getLoginName, username)
                .eq(User::getLockedFlag, 0)
                .one();
        Assert.notNull(user, "用户不存在");

        String md5Encode = MD5Util.MD5Encode(password, CharsetUtil.UTF_8);
        if(!md5Encode.equals(user.getPasswordMd5()))
            Assert.fail("用户密码不正确");

        return user;
    }
}
