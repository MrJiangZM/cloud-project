package com.ming.blog.service.impl;

import com.ming.blog.dao.PaymentDao;
import com.ming.blog.entities.Payment;
import com.ming.blog.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author MrJiangZM
 * @date 2020/12/4 21:15
 */
@Slf4j
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int save(Payment payment) {
        return paymentDao.save(payment);
    }

    @Override
    public Payment findById(Long id) {
        return paymentDao.findById(id);
    }
}
