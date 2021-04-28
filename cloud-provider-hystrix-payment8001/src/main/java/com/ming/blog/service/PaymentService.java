package com.ming.blog.service;

import org.springframework.stereotype.Service;

/**
 * @author MrJiangZM
 */
@Service
public class PaymentService {

    public String paymentOk(Integer id) {
        return "返回成功啦" + Thread.currentThread().getName() + "is ok";
    }

    public String paymentTimeOut(Integer id) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(id + "-------111111111");
        return "返回成功啦" + Thread.currentThread().getName() + "is timeout";
    }

}
