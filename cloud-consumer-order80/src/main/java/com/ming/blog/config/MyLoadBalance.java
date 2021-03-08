package com.ming.blog.config;

import org.springframework.cloud.client.ServiceInstance;
import java.util.List;

/**
 * @author Jiang Zaiming
 * @date 2021/3/8 13:38
 */
public interface MyLoadBalance {

     ServiceInstance instances(List<ServiceInstance> serviceInstanceList);

}
