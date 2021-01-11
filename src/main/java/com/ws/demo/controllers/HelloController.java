package com.ws.demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {

    @GetMapping("")
    public String index(){
        return "Hello World!";
    }

    @Value("${spring.application.name}")
    private String name;

    @GetMapping(value = "/name")
    public String name(){
        return name;
    }

}
