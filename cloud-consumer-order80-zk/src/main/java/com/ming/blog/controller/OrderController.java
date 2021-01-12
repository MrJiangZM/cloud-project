package com.ming.blog.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;

/**
 * @author MrJiangZM
 * @date 2021/1/12 20:52
 */
@RestController
@Slf4j
public class OrderController {

    public static final String URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;


    @GetMapping("/order/zk")
    public void test() {
        String forObject = restTemplate.getForObject(URL + "/payment/zk", String.class);
        System.out.println(forObject);


    }

}
