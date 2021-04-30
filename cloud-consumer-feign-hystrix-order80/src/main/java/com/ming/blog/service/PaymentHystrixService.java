package com.ming.blog.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Jiang Zaiming
 * @date 2021/4/28 22:24
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",
        fallback = PaymentHystrixServiceFallbackImpl.class)
public interface PaymentHystrixService {

    @GetMapping("/ok/{id}")
    public String paymentOk(@PathVariable("id") Integer id);

    @GetMapping("/timeout/{id}")
    public String paymentTimeout(@PathVariable("id") Integer id);



}
