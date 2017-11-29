package com.github.liurui.springdemo.partition;

import com.github.liurui.springdemo.User;
import com.github.liurui.springdemo.data.Log;
import com.github.liurui.springdemo.data.LogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.ComponentScan;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
@EnableBinding(Sink.class)
@ComponentScan(basePackageClasses = LogRepository.class)
public class App {
    public static final Logger LOGGER = LoggerFactory.getLogger(App.class);


    @Autowired
    LogRepository logRepository;

    @StreamListener(Sink.INPUT)
    public void receive(Log msg) {
        int i = ThreadLocalRandom.current().nextInt(10);
        if (i == 1) {
            LOGGER.error("error {}", msg.getId());
            throw new IllegalArgumentException();
        } else {
            msg.setOk(true);
            msg.setUpdateDate(new Date());
            logRepository.save(msg);
            LOGGER.error("ok {}", msg.getId());
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
