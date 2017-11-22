package com.github.liurui.springdemo.news.repositories;

import com.github.liurui.springdemo.CityApi;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "CommonData", fallback = CityApiRepositoryFallback.class)
public interface CityApiRepository extends CityApi {
}


