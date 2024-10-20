package com.nextech.cache.poc;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/objects")
@Slf4j
@RequiredArgsConstructor
public class DataController {

    private final DataService dataService;

    @GetMapping
    public ResponseEntity<Object> getData() {
        return ResponseEntity.ok(dataService.getObject());
    }
}
