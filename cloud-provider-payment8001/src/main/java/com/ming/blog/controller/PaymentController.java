package com.ming.blog.controller;

import com.ming.blog.common.CommonResult;
import com.ming.blog.entities.Payment;
import com.ming.blog.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author MrJiangZM
 * @date 2020/12/4 21:14
 */
@RestController
@RequestMapping("/v1.0/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping("/save")
    public CommonResult<String> save(@RequestBody Payment payment) {
        paymentService.save(payment);
        return new CommonResult<>(200, "success");
    }

    @GetMapping("/findById")
    public CommonResult<Payment> findById(Long id) {
        return new CommonResult<>(200, "success", paymentService.findById(id));
    }



}
