package com.github.liurui.springdemo.order.repositories;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;


@Component
@RequestMapping("cityfallback")
public class CityApiRepositoryFallback implements CityApiRepository {
    @Override
    public String get(String id) {
        return String.format("error %s", id);
    }
}


