package com.example.mpg.service;


import com.example.mpg.entity.AdminUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2021-11-08
 */
public interface AdminUserService extends IService<AdminUser> {

    AdminUser login(String username, String password);

}
