package com.github.liurui.springdemo.order.controllers;

import com.github.liurui.springdemo.order.entities.Order;
import com.github.liurui.springdemo.order.entities.User;
import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
@Api(tags = {"订单"}, description = "订单基本操作")
@RequestMapping("/order")
public class OrderController {
    public static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(method = RequestMethod.POST)
    public Order create(@ApiParam(name = "userId", value = "用户编码", required = true)
                        @RequestParam
                                String userId,
                        @RequestParam
                        @ApiParam(name = "amount", value = "金额", required = true)
                                float amount) {

        HashMap<String,String> map = Maps.newHashMap();

        map.put("name" , "ren");
        map.put("code" , "34");
        User user = restTemplate.getForObject("http://user/user/{code}{name}", User.class , map);

        LOGGER.error(user.toString());
        return new Order(1, Long.valueOf(userId), "刘锐", amount);
    }
}