package com.github.liurui.springdemo;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RabbitListener(queues = {"hello"})
public class Consumer {

    @RabbitHandler
    public void process(Date message) {
        System.out.println(message);
    }
}
