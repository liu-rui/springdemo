package com.github.liurui.springdemo;

import com.github.liurui.springdemo.data.Configuration;
import com.github.liurui.springdemo.data.Log;
import com.github.liurui.springdemo.data.LogRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Configuration.class)
public class AppTest {
    @Autowired
    LogRepository logRepository;

    @Test
    public void test() {
        Log log = new Log(false, new Date(), new Date());
        try {
            logRepository.save(log);
            assertNotEquals(0, log.getId());
        } finally {
            try {
                if (log.getId() != 0) {
                    logRepository.delete(log);
                }
            } catch (Exception ex) {
            }
        }
    }
}