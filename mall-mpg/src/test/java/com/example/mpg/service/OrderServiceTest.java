package com.example.mpg.service;

import cn.hutool.json.JSONUtil;
import cn.hutool.json.serialize.JSONObjectSerializer;
import com.example.common.util.JSONUtils;
import com.example.common.util.SpringUtil;
import com.example.mpg.entity.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootTest
public class OrderServiceTest {

    @Resource
    private OrderService orderService;

    @Test
    public void test1() {
        orderService.list().forEach(order -> {
            String json = JSONUtils.toJson(order);
            System.out.println(json);
            Order obj = JSONUtils.parse(json, Order.class);
            System.out.println(obj);
        });
    }
}
