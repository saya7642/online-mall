package com.example.mpg.service;

import com.example.mpg.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2021-11-08
 */
public interface UserService extends IService<User> {

    User login(String username, String password);
}
