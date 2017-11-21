package com.github.liurui.springdemo.news.services;

import com.github.liurui.springdemo.news.entities.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CityService {
    public static final Logger LOGGER = LoggerFactory.getLogger(CityService.class);
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallback" , commandKey = "GetByCityId" , groupKey = "City")
    public String get(String id) {
        long start = System.currentTimeMillis();
        String name= restTemplate.getForObject("http://user/user/{1}", String.class, id);

        LOGGER.error("service get {} escaped:{}" , name , System.currentTimeMillis() - start);
        return name;
    }

    public String getFallback(String id) {
        String ret ="未知的城市";

        LOGGER.error("broker getFallback {}" , ret);
        return ret;
    }
}
