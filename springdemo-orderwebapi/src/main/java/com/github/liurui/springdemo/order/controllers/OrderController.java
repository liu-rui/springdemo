package com.github.liurui.springdemo.order.controllers;

import com.github.liurui.springdemo.order.entities.Order;
import com.github.liurui.springdemo.order.repositories.CityApiRepository;
import com.github.liurui.springdemo.order.repositories.UserApiRepository;
import com.github.liurui.springdemo.user.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = {"订单"}, description = "订单基本操作")
@RequestMapping("/order")
public class OrderController {
    public static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    UserApiRepository userApiRepository;
    @Autowired
    CityApiRepository cityApiRepository;

    @RequestMapping(method = RequestMethod.POST)
    public Order create(@ApiParam(name = "userId", value = "用户编码", required = true)
                        @RequestParam
                                long userId,
                        @RequestParam
                        @ApiParam(name = "amount", value = "金额", required = true)
                                float amount) {
        User user = userApiRepository.info(userId);
        LOGGER.error("controller  {}" , user);
        LOGGER.error("controller  {}" , userApiRepository.login("sd" , "sdd"));
        LOGGER.error("controller  {}", cityApiRepository.get(String.valueOf(userId)));
        return new Order(1, Long.valueOf(userId), user.getName(), amount);
    }
}
