package com.ming.blog.controller;

import com.ming.blog.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author MrJiangZM
 */
@RestController
@DefaultProperties(defaultFallback = "payOrderTimeoutHandlerGlobal", commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
})
public class OrderController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/ok/{id}")
    public String payOrderOk(@PathVariable Integer id) {
        return paymentHystrixService.paymentOk(id);
    }

    @GetMapping("/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "payOrderTimeoutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000")
//    })
    @HystrixCommand
    public String payOrderTimeout(@PathVariable Integer id) {
        System.out.println("cheshi gagagagag");
        String s = paymentHystrixService.paymentTimeout(id);
//        int a = 1 / 0;
        return s;
    }

    @GetMapping("/timeout2/{id}")
//    @HystrixCommand(fallbackMethod = "payOrderTimeoutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000")
//    })
    @HystrixCommand
    public String payOrderTimeout2(@PathVariable Integer id) {
        System.out.println("cheshi gagagagag");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "超时了呀";
    }

    @GetMapping("/timeout3/{id}")
    @HystrixCommand(fallbackMethod = "payOrderTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000")
    })
//    @HystrixCommand
    public String payOrderTimeout3(@PathVariable Integer id) {
        System.out.println("cheshi gagagagag");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "timeout3自己返回的数据呀";
    }

    public String payOrderTimeoutHandler(@PathVariable Integer id) {
        System.out.println("cheshi ");
        return "自定义超时或报错了呀";
    }

    public String payOrderTimeoutHandlerGlobal() {
        return "全局超时或报错了呀";
    }

    @GetMapping("/rest/{id}")
    public String timeout(@PathVariable Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:8001/timeout/1", String.class, new HashMap<>());
        return "responseEntity" + responseEntity.getBody();
    }

}
