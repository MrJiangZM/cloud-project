//package com.ming.blog.config;
//
//import cn.hutool.aop.ProxyUtil;
//import cn.hutool.core.util.StrUtil;
//import com.ming.blog.service.PaymentHystrixService;
//import feign.FeignException;
//import feign.RetryableException;
//import feign.Target;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//import java.lang.reflect.Method;
//
///**
// * @author MrJiangZM
// */
//@Slf4j
//@Component
//public class GlobalFallbackFactory extends ExtFallbackFactory<PaymentHystrixService> {
//
//    private static final ThrowableAnalyzer THROWABLE_ANALYZER = new DefaultThrowableAnalyzer();
//
//    @Override
//    public T create(Method method, Throwable cause) {
//        return createFallbackService(cause, method.getDeclaringClass());
//    }
//
//    private T createFallbackService(Throwable ex, Class<?> targetClass) {
//        Throwable[] causeChain = THROWABLE_ANALYZER.determineCauseChain(ex);
//        RetryableException ase1 = (RetryableException) THROWABLE_ANALYZER.getFirstThrowableOfType(RetryableException.class, causeChain);
//        log.error("服务出错了", ex);
//        if (ase1 != null) {
//            return toResponse("服务[{}]接口调用超时！", ase1.request());
//        }
//        FeignException ase2 = (FeignException) THROWABLE_ANALYZER.getFirstThrowableOfType(FeignException.class, causeChain);
//        if (ase2 != null) {
//            return toResponse("服务[{}]接口调用出错了！", ase2.request());
//        }
//
//        // 创建一个JDK代理类
//        return ProxyUtil.newProxyInstance((proxy, method, args) -> XCloudResponse.failed(ex.getMessage()), targetClass);
//    }
//
//    private T toResponse(String respMsg, Request request) {
//        Target<?> target = request.requestTemplate().feignTarget();
//        Class<?> targetClazz = target.type();
//        String serviceName = target.name();
//        return ProxyUtil.newProxyInstance((proxy, method, args) -> XCloudResponse.failed(StrUtil.format(respMsg, serviceName)), targetClazz);
//    }
//
//
//}
