package com.ming.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author MrJiangZM
 * @since <pre>2021/7/23</pre>
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaOrder84Application {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaOrder84Application.class, args);
    }

}
