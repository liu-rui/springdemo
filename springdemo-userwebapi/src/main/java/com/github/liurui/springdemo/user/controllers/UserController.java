package com.github.liurui.springdemo.user.controllers;

import com.github.liurui.springdemo.user.User;
import com.github.liurui.springdemo.user.UserApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController
public class UserController implements UserApi {
    public static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Override
    public User info(@PathVariable long id) {
        User user =  new User(id, "刘锐 " + id);
        LOGGER.error("user:{}  sleep:{}" , user.toString() , -1);
        return user;
    }

    @Override
    public String login(@RequestParam String name, @RequestParam String password) {
        String ret =  String.format("name:%s password:%s sleep:%d", name, password ,-1);
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
