package com.github.liurui.springdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    Environment environment;

    @RequestMapping(method = RequestMethod.GET)
    public String get() {
//        return "HELLO";
        return environment.getProperty("firstValue");
    }
}
