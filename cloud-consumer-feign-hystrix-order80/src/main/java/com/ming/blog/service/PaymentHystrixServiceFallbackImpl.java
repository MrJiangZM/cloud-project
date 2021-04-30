package com.ming.blog.service;

import org.springframework.stereotype.Component;

/**
 * @author MrJiangZM
 */
@Component
public class PaymentHystrixServiceFallbackImpl implements PaymentHystrixService {
    @Override
    public String paymentOk(Integer id) {
        return "这个ok方法报错了呀";
    }

    @Override
    public String paymentTimeout(Integer id) {
        return "这个timeout方法有问题了也";
    }
}
