package com.example.security.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于配置白名单资源路径
 * Created by admin on 2021/10/01.
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "mall.security")
public class SecurityProperties {

    private List<String> ignoreUrls = new ArrayList<>();

}
