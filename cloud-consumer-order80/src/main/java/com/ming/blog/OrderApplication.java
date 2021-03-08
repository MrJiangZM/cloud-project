package com.ming.blog;

import com.ming.rule.MyRule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author MrJiangZM
 * @date 2020/12/6 14:32
 */
@RibbonClient(name = "CLOUD-PROVIDER-PAYMENT", configuration = MyRule.class)
@Slf4j
@EnableEurekaClient
@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
        log.info("order application start success");
    }

}
