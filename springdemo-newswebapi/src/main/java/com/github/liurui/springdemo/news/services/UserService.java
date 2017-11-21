package com.github.liurui.springdemo.news.services;

import com.github.liurui.springdemo.news.entities.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    public static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallback")
    public User get(long id) {
        long start = System.currentTimeMillis();
        User user = restTemplate.getForObject("http://user/user/info/{1}", User.class, id);

        LOGGER.error("service get {} escaped:{}" , user , System.currentTimeMillis() - start);
        return user;
    }

    public User getFallback(long id) {
        User user = new User(-1, "error");

        LOGGER.error("broker getFallback {}" , user);
        return user;
    }

    @HystrixCommand(fallbackMethod = "loginFallback")
    public  String login(String name , String password){
        long start = System.currentTimeMillis();
        String info = restTemplate.getForObject("http://user/user/login?name={0}&password={1}", String.class, name,password);
        LOGGER.error("service login {} escaped:{}" , info , System.currentTimeMillis() - start);
        return info;
    }


    public  String loginFallback(String name , String password){
        String ret =  String.format("%s %s fallback" , name,  password);
        LOGGER.error("broker loginFallback {}" , ret);
        return ret;
    }
}
