package com.nextech.cache.poc.keyGenerators;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Method;

public class CustomWideKeyGenerator implements KeyGenerator {

    private final String keySeparator;

    public CustomWideKeyGenerator(String keySeparator) {
        this.keySeparator = keySeparator;
    }

    @Override
    public Object generate(Object target, Method method, Object... params) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();

        String sessionId = request.getSession().getId();
        String queryParam = request.getQueryString();

        return String.join(keySeparator, method.getName(), sessionId, queryParam);
    }
}
