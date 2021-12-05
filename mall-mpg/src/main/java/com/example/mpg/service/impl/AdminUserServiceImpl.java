package com.example.mpg.service.impl;

import cn.hutool.core.util.CharsetUtil;
import com.example.common.exception.Assert;
import com.example.mpg.entity.AdminUser;
import com.example.mpg.mapper.AdminUserMapper;
import com.example.mpg.service.AdminUserService;
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
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper, AdminUser> implements AdminUserService {


    @Override
    public AdminUser login(String username, String password) {
        AdminUser adminUser = lambdaQuery()
                .eq(AdminUser::getLoginUserName, username)
                .eq(AdminUser::getLocked, 0)
                .one();
        Assert.notNull(adminUser, "管理员账户不存在");

        String md5Encode = MD5Util.MD5Encode(password, CharsetUtil.UTF_8);
        if(!md5Encode.equals(adminUser.getLoginPassword()))
            Assert.fail("管理员密码不正确");

        return adminUser;
    }
}
