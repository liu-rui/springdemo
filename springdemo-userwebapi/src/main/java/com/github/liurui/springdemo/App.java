package com.github.liurui.springdemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableDiscoveryClient
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder().sources(App.class).run(args);
    }
}
