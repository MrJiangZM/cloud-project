package com.ming.blog;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author MrJiangZM
 * @date 2021/1/12 20:46
 */
@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsumerZkApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderConsumerZkApplication.class, args);
    }

}
