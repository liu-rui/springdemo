package com.github.liurui.springdemo;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

    @Bean
    Queue queue(){
        return new Queue("hello");
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
