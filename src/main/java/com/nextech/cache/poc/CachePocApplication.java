package com.nextech.cache.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CachePocApplication {

    public static void main(String[] args) {
        SpringApplication.run(CachePocApplication.class, args);
    }

}
