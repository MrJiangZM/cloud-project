package com.ming.blog.dao;

import com.ming.blog.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @author MrJiangZM
 * @date 2020/12/5 18:58
 */
@Mapper
public interface PaymentDao {

    int save(Payment payment);

    Payment findById(@Param("id") Long id);

    List<Payment> list();

}
