package com.nextech.cache.poc;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class IntegrationService {

    private RestTemplate restTemplate = new RestTemplate();
    private final String url = "https://cat-fact.herokuapp.com/facts/";

    @Cacheable(value = "data", keyGenerator = "dynamicKeyGenerator")
    public Object getData(String data) {
        ResponseEntity<Object> response
                = restTemplate.getForEntity(url, Object.class);
        return response.getBody();
    }
}
