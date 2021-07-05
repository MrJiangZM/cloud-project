package com.ming.blog.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author MrJiangZM
 * @since <pre>2021/6/30</pre>
 */
@Configuration
public class Gateway {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("custom_path", route -> route.path("/guonei").uri("http://news.baidu.com/guonei"))
                .build();
        return routes.build();
    }

}
