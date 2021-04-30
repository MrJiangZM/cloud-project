package com.ming.blog.config;

import feign.hystrix.FallbackFactory;
import java.lang.reflect.Method;

/**
 * @author MrJiangZM
 */
public abstract class ExtFallbackFactory<T> implements FallbackFactory<T> {
    @Override
    public T create(Throwable throwable) {
        return null;
    }

    public abstract T create(Method method, Throwable cause);

}
