package com.github.liurui.springdemo.commondata.controllers;

import com.github.liurui.springdemo.CityApi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;


@RestController
public class CityController implements CityApi {
    public static final Logger LOGGER = LoggerFactory.getLogger(CityController.class);

    @Override
    public String get(@PathVariable("id") String id) {
        String ret = String.format("id:%s name:%s  sleep:%d", id, "城市名beijing", -1);
        LOGGER.error(ret);
        return ret;
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
