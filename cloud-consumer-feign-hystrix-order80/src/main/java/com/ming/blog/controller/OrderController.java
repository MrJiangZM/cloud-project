package com.ming.blog.controller;

import com.ming.blog.service.PaymentHystrixService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * @author MrJiangZM
 */
@RestController
public class OrderController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/ok/{id}")
    public String payOrderOk(@PathVariable Integer id) {
        return paymentHystrixService.paymentOk(id);
    }

    @GetMapping("/timeout/{id}")
    public String payOrderTimeout(@PathVariable Integer id) {
        return paymentHystrixService.paymentTimeout(id);
    }

}
