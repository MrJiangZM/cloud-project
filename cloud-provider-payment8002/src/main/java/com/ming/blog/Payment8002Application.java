package com.ming.blog;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author MrJiangZM
 * @date 2020/12/4 21:09
 */
@Slf4j
@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
public class Payment8002Application {

    public static void main(String[] args) {
        SpringApplication.run(Payment8002Application.class, args);
        log.info("payment service start success");
    }

}
