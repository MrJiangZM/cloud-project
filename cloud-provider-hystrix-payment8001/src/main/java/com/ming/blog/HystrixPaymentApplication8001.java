package com.ming.blog;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author MrJiangZM
 */
@Slf4j
@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
public class HystrixPaymentApplication8001 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixPaymentApplication8001.class, args);
    }

}
