package com.ming.blog.controller;

import com.ming.blog.common.CommonResult;
import com.ming.blog.entities.Payment;
import com.ming.blog.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author MrJiangZM
 * @date 2020/12/4 21:14
 */
@RestController
@RequestMapping("/v1.0/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;
    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/save")
    public CommonResult<String> save(@RequestBody Payment payment) {
        paymentService.save(payment);
        System.out.println("11112341341513411");
        return new CommonResult<>(200, serverPort);
    }

    @GetMapping("/get/findById")
    public CommonResult<Payment> findById(Long id) {
        System.out.println(serverPort + "---" + serverPort);
        return new CommonResult<>(200, serverPort, paymentService.findById(id));
    }

    @GetMapping("/lb/service")
    public CommonResult<Object> service(Long id) {
        List<String> services = discoveryClient.getServices();
        for (String e : services) {
            System.out.println(e);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance i : instances) {
            System.out.println(i.getServiceId() + "\t" + i.getHost() + "\t" + i.getHost() + "\t" + i.getPort() + "\t" + i.getUri());

        }
        return new CommonResult<>(200, serverPort, paymentService.findById(id));
    }



}
