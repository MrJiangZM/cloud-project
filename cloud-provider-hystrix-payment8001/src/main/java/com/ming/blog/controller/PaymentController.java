package com.ming.blog.controller;

import com.ming.blog.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * @author MrJiangZM
 */
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/ok/{id}")
    public String paymentOk(@PathVariable Integer id) {
        System.out.println("okokok");
        return paymentService.paymentOk(id);
    }

    @GetMapping(value = "/timeout/{id}")
    public String paymentTimeout(@PathVariable Integer id) {
        System.out.println("timeout");
        return paymentService.paymentTimeOut(id);
    }


}
