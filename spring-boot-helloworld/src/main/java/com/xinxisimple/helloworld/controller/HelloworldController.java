package com.xinxisimple.helloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldController {

    @RequestMapping("/hello")
    public String index() {
        return "Hello World!" + System.currentTimeMillis();
    }
}
