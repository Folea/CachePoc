package com.nextech.cache.poc.keyGenerators;

import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;

public class ApplicationWideKeyGenerator implements KeyGenerator {
    @Override
    public Object generate(Object target, Method method, Object... params) {
        return method.getName();
    }
}
