package com.github.liurui.springdemo.partition;

import com.github.liurui.springdemo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(Sink.class)
public class App {
    public static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    @StreamListener(Sink.INPUT)
    public void receive(User msg) {
        LOGGER.error(msg.toString());
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
