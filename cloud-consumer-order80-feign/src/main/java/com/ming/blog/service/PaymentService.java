package com.ming.blog.service;

import com.ming.blog.common.CommonResult;
import com.ming.blog.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author MrJiangZM
 * @date 2020/12/4 21:14
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-PAYMENT")
public interface PaymentService {

//    int save(Payment payment);

    @GetMapping(value = "/v1.0/payment/findById")
    CommonResult<Payment> findById(@RequestParam("id") Long id);

}
