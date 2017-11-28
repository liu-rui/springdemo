package com.github.liurui.springdemo.partition;

import com.github.liurui.springdemo.data.Log;
import com.github.liurui.springdemo.data.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

import java.util.Date;


@SpringBootApplication
@EnableBinding(Source.class)
@ComponentScan("com.github.liurui.springdemo.data")
public class App {
    @Autowired
    LogRepository logRepository;

    @Bean
    @InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "2000"))
    public MessageSource<Log> send() {
        return () -> {
            Log log = new Log(false, new Date(), new Date());

            logRepository.save(log);
            return new GenericMessage<>(log);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
