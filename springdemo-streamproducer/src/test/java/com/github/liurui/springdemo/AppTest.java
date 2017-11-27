package com.github.liurui.springdemo;


import com.github.liurui.springdemo.rx.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class AppTest {
//    @Autowired
//    MessageChannel input;

    @Autowired
    Source source;

    @Test
    public void test() {
        source.output().send(MessageBuilder.withPayload("hello world").build());
    }
}
