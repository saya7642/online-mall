package com.example.service.impl;

import com.example.entity.ShoppingCartItem;
import com.example.mapper.ShoppingCartItemMapper;
import com.example.service.ShoppingCartItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2021-11-23
 */
@Service
public class ShoppingCartItemServiceImpl extends ServiceImpl<ShoppingCartItemMapper, ShoppingCartItem> implements ShoppingCartItemService {

}
