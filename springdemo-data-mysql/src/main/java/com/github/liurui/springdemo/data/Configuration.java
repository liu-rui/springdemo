package com.github.liurui.springdemo.data;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@org.springframework.context.annotation.Configuration
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = {Log.class})
public class Configuration {
}
