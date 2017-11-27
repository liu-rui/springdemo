package com.github.liurui.springdemo.rx;

import com.github.liurui.springdemo.User;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableBinding(Processor.class)
public class ServiceB {
    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public User exec(User message) {
        message.setName(message.getName() + "   ddd");
        return message;
    }
}
