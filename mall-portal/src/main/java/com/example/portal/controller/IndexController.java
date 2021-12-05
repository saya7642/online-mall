package com.example.portal.controller;

import com.example.common.api.R;
import com.example.mpg.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/index")
public class IndexController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/user/{id}")
    public R findUserById(@PathVariable Long id) {
        String url = "http://mall-admin/admin/user/{0}";
        return restTemplate.getForObject(url, R.class, id);
    }

    @GetMapping("/user")
    public R findUser() {
        String url = "http://mall-admin/admin/user";
        return restTemplate.getForObject(url, R.class);
    }
}
