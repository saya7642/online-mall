package com.example.mpg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;

@ComponentScan(basePackages = "com.example")
@SpringBootApplication
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class);
        ConfigurableEnvironment env = context.getEnvironment();
        String port = env.getProperty("server.port");

        logger.info("项目启动地址：http://localhost:{}/", port);
        logger.info("swagger接口文档地址：http://localhost:{}/doc.html", port);
    }
}
