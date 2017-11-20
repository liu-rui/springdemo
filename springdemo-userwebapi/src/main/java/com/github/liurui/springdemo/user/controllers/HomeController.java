package com.github.liurui.springdemo.user.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HomeController {
    @RequestMapping("/")
    public String get() {
        return "redirect:swagger-ui.html";
    }

}
