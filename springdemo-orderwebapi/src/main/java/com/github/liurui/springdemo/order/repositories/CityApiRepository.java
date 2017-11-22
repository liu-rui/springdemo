package com.github.liurui.springdemo.order.repositories;

import com.github.liurui.springdemo.CityApi;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "CommonData", fallback = CityApiRepositoryFallback.class)
public interface CityApiRepository extends CityApi {
}


