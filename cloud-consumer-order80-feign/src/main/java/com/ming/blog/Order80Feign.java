package com.ming.blog;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author MrJiangZM
 * @date 2021/3/8 14:07
 */
@SpringBootApplication
@EnableFeignClients
@Slf4j
@EnableEurekaClient
public class Order80Feign {

    public static void main(String[] args) {
        SpringApplication.run(Order80Feign.class, args);
    }

}
