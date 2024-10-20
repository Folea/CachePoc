package com.nextech.cache.poc;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
@Slf4j
public class DataService {

    private final IntegrationService integrationService;

    public Object getObject() {
        return integrationService.getData("test");
    }
}
