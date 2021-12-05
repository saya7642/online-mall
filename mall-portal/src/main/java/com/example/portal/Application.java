package com.example.portal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;

@ComponentScan(basePackages = "com.example")
@EnableFeignClients(basePackages = "com.example")
@EnableDiscoveryClient
@SpringBootApplication
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class);
        ConfigurableEnvironment env = context.getEnvironment();
        String name = env.getProperty("spring.application.name");
        String port = env.getProperty("server.port");
        String contextPath = env.getProperty("server.servlet.context-path");
        String host = InetAddress.getLocalHost().getHostAddress();

        logger.info("项目{}启动地址：http://{}:{}{}", name, host, port, contextPath);
        logger.info("swagger接口文档地址：http://{}:{}{}/doc.html", host, port, contextPath);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
