package com.github.liurui.springdemo.user.controllers;

import com.github.liurui.springdemo.user.entities.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@Api(tags = "用户", description = "用户基本操作")
@RequestMapping(path = "/user")
public class UserController {
    public static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(path = "info/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "根据用户编码获取信息", notes = "根据用户编码获取信息")
    public User info(@PathVariable
                     @ApiParam(required = true, name = "id", value = "用户编码")
                             long id) throws InterruptedException {

        sleep();
        return new User(id, "刘锐 " + id);
    }

    @RequestMapping(path = "login/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "登录", notes = "登录")
    public String login(String name, String password) {
        sleep();
        return String.format("name:%s password:%s", name, password);
    }

    private long sleep() {
        int sleep = ThreadLocalRandom.current().nextInt(3000);
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return sleep;
    }
}
