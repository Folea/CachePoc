package com.nextech.cache.poc.config;

import com.nextech.cache.poc.keyGenerators.ApplicationWideKeyGenerator;
import com.nextech.cache.poc.keyGenerators.CustomWideKeyGenerator;
import com.nextech.cache.poc.keyGenerators.SessionWideKeyGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class BeanConfig {

    @Value("${cache.key.generator.separator}")
    private String cacheKeySeparator;

    @Value("${cache.key.generator}")
    private String cacheKeyGenerator;


    @Bean("dynamicKeyGenerator")
    public KeyGenerator keyGenerator() {
        switch (cacheKeyGenerator) {
            case "ApplicationWideKeyGenerator":
                return new ApplicationWideKeyGenerator();
            case "CustomWideKeyGenerator":
                return new CustomWideKeyGenerator(cacheKeySeparator);
            case "SessionWideKeyGenerator":
                return new SessionWideKeyGenerator(cacheKeySeparator);

            default:
                log.error("No custom cache key generator configured, ApplicationWideKeyGenerator will be used");
                return new ApplicationWideKeyGenerator();
        }
    }
}
