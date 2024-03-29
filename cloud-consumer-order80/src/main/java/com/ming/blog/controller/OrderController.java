package com.ming.blog.controller;

import com.ming.blog.common.CommonResult;
import com.ming.blog.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MrJiangZM
 * @date 2020/12/6 14:36
 */
@Slf4j
@RestController
@RequestMapping("/consumer/v1.0/order")
public class OrderController {

    private static final String URL = "http://localhost:8010";
//    private static final String URL = "http://CLOUD-PROVIDER-PAYMENT";

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/save")
    public CommonResult<Payment> save(@RequestBody Payment payment) {
        log.info("save payment");
        return restTemplate.postForObject(URL + "/v1.0/payment/save", payment, CommonResult.class);
    }

    @GetMapping("/findById")
    public CommonResult<Payment> findById(Long id) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT");
        instances.forEach(i -> System.out.println(i.getUri()));
        return restTemplate.getForObject(URL + "/v1.0/payment/get/findById?id=" + id, CommonResult.class, paramMap);
    }

}
