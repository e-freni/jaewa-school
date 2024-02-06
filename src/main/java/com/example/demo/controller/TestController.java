package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test-endpoint")
    public ResponseEntity<String> testEndpoint() {

        return new ResponseEntity<>("This is Houston, what can we do for you FE application?", HttpStatus.OK);
    }
}
