package com.example.admin.config;

import com.example.common.config.swagger.BaseSwaggerConfig;
import com.example.common.config.swagger.SwaggerProperties;
import org.springframework.stereotype.Component;

@Component
public class SwaggerConfiguration extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .title("在线购物商城")
                .groupName("后台接口文档")
                .apiBasePackage("com.example")
                .contactName("admin")
                .description("商城api文档")
                .version("1.0")
                .enableSecurity(false)
                .build();
    }

}
