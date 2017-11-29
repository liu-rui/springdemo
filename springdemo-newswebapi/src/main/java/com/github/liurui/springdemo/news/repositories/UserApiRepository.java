package com.github.liurui.springdemo.news.repositories;

import com.github.liurui.springdemo.user.UserApi;
import org.springframework.cloud.netflix.feign.FeignClient;


@FeignClient(value = "user-v1", fallback = UserApiRepositoryFallback.class)
public interface UserApiRepository extends UserApi {
}