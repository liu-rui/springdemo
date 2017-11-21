package com.github.liurui.springdemo.commondata.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;


@RestController
@Api(tags = "城市", description = "城市基本操作")
@RequestMapping(path = "/city")
public class CityController {
    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    @ApiOperation(value = "获取城市名称", notes = "获取城市名称")
    public String get(String id) {
        sleep();
        return String.format("id:%s name:%s", id, "城市名beijing");
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
