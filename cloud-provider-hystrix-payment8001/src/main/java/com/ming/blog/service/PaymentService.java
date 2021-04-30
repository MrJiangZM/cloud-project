package com.ming.blog.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author MrJiangZM
 */
@Service
public class PaymentService {

    public String paymentOk(Integer id) {
        return "返回成功啦" + Thread.currentThread().getName() + "is ok";
    }

    @HystrixCommand(fallbackMethod = "paymentTimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "6000")
    })
    public String paymentTimeOut(Integer id) {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(id + "-------111111111");
        return "返回成功啦" + Thread.currentThread().getName() + "is timeout";
    }

    @HystrixCommand(fallbackMethod = "paymentTimeOutHandler", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),// 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") // 失败率达到多少后跳闸
    })
    public String testRongduan(@PathVariable("id") Integer id ) {
        if (id < 0) {
            throw new RuntimeException("id 不能是负数啊");
        }
        // 如果大批量调用，导致出发了熔断器，经过配置后，熔断器关闭，类似于时间窗口算法等，限流算法
        return "流水号" + IdUtil.simpleUUID();
    }

    public String paymentTimeOutHandler(Integer id) {
        System.out.println("test");
        return "这个方法超时了呀 paymentTimeOutHandler" + id;
    }

}
