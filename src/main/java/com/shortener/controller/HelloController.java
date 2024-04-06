package com.shortener.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping( value = {"/", "/hello"})
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello from HelloController!");
    }
}
