package com.ming.blog.service;

import com.ming.blog.entities.Payment;

/**
 * @author MrJiangZM
 * @date 2020/12/4 21:14
 */
public interface PaymentService {

    int save(Payment payment);

    Payment findById(Long id);

}
