package com.github.liurui.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

@SpringCloudApplication
@EnableZuulProxy
public class App {
    @Bean
    PatternServiceRouteMapper   patternServiceRouteMapper(){
        return new PatternServiceRouteMapper("(?<name>.*)-(?<version>v.*$)","${version}/${name}");
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
