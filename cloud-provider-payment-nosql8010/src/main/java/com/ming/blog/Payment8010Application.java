package com.ming.blog;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author MrJiangZM
 * @since <pre>2021/7/21</pre>
 */
@Slf4j
@EnableEurekaClient
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class Payment8010Application {

    public static void main(String[] args) {
        SpringApplication.run(Payment8010Application.class, args);
    }

}
