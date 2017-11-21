package com.github.liurui.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 监控单个服务的地址为：/application/hystrix.stream
 * 例如：http://172.18.101.2:8101/application/hystrix.stream
 */
@SpringBootApplication
@EnableHystrixDashboard
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
