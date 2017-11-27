package com.github.liurui.springdemo.rx;

import com.github.liurui.springdemo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

import java.util.concurrent.atomic.AtomicInteger;

@EnableBinding(Processor.class)
public class ServiceA {
    public static final AtomicInteger atomicInteger = new AtomicInteger();
    public static final Logger LOGGER = LoggerFactory.getLogger(ServiceA.class);

    @Bean
    @InboundChannelAdapter(value = Processor.OUTPUT, poller = @Poller(fixedDelay = "2000"))
    public MessageSource<User> send() {
        return () -> {
            int id = atomicInteger.incrementAndGet();
            return new GenericMessage<>(new User(id, "name " + id));
        };
    }

    @StreamListener(Processor.INPUT)
    public void receive(User message) {
        LOGGER.warn("receive  {}", message);
    }
}
