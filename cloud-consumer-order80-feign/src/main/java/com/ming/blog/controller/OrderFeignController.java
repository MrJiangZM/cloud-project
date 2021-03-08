package com.ming.blog.controller;

import com.ming.blog.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * @author MrJiangZM
 * @date 2021/3/8 14:15
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/test")
    public Object findById(Long id) {
        System.out.println(id);
        return paymentService.findById(id);
    }

}
