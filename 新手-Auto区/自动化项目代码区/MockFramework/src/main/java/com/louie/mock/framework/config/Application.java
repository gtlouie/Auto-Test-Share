package com.louie.mock.framework.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Spring Boot 启动类
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.louie.**"})
public class  Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
