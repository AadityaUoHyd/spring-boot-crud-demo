package org.aadi.springboot.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HelloController {

    @Value("${welcome.message}")
    private String welcomeMesssage;

    @GetMapping("/welcome")
    public String helloWorld() {
        return welcomeMesssage;
    }
}

//To verify your profile type, try this URL in browser : http://localhost:8081/api/v1/welcome
