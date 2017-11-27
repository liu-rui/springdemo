package com.github.liurui.springdemo.partition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

import java.util.concurrent.atomic.AtomicInteger;


@SpringBootApplication
@EnableBinding(Source.class)
public class App {
    public static final AtomicInteger ID = new AtomicInteger();

    @Bean
    @InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "2000"))
    public MessageSource<String> send() {
        return () -> new GenericMessage<>(String.valueOf(ID.incrementAndGet()));
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
