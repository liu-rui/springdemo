package com.github.liurui.springdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

        try{
            int a = 10;
            int b = 0;
            int c = a/b;
        }catch (Exception ex){
            LOGGER.error(ex.getMessage() , ex);
        }


//        LOGGER.info("hello world debug");
//        LOGGER.info("hello world info");
//        LOGGER.warn("hello world warn");
//        LOGGER.error("hello world error");
    }
}