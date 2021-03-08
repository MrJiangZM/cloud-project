package com.ming.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author MrJiangZM
 * @date 2021/3/8 12:51
 */
@Configuration
public class MyRule {

    @Bean
    public IRule mySelfRule() {
        return new RandomRule();
    }

}
