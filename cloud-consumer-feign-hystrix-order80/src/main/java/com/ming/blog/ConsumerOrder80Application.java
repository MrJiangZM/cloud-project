package com.ming.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author MrJiangZM
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class ConsumerOrder80Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrder80Application.class, args);
    }

}
