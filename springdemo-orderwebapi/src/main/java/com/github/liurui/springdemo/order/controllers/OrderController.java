package com.github.liurui.springdemo.order.controllers;

import com.github.liurui.springdemo.order.entities.Order;
import com.github.liurui.springdemo.order.entities.User;
import com.github.liurui.springdemo.order.services.UserService;
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
    UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public Order create(@ApiParam(name = "userId", value = "用户编码", required = true)
                        @RequestParam
                                long userId,
                        @RequestParam
                        @ApiParam(name = "amount", value = "金额", required = true)
                                float amount) {
        User user = userService.get(userId);
        LOGGER.error("controller  {}" , user);
        return new Order(1, Long.valueOf(userId), user.getName(), amount);
    }
}
