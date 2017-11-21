package com.github.liurui.springdemo.order.services;

import com.github.liurui.springdemo.order.controllers.OrderController;
import com.github.liurui.springdemo.order.entities.User;
import com.google.common.collect.Maps;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
public class UserService {
    public static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallback")
    public User get(long id) {
        long start = System.currentTimeMillis();
        User user = restTemplate.getForObject("http://user/user/{1}", User.class, id);

        LOGGER.error("service  {} escaped:{}" , user , System.currentTimeMillis() - start);
        return user;
    }

    public User getFallback(long id) {
        User user = new User(-1, "error");

        LOGGER.error("broker {}" , user);
        return user;
    }
}
