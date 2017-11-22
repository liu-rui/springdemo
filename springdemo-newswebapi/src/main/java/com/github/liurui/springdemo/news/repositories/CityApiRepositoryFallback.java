package com.github.liurui.springdemo.news.repositories;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 当webapi使用继承方式时，回调类有巨大的坑
 * 1. 必须使用@Component，需要注入，否则会报 java.lang.IllegalStateException: No fallback instance of type class异常。
 * 2.会报映射关系已存在的异常
 * 方法1: 修改请求映射，规范：新的映射名为 "原有的fallback"
 * 3.实现注解@FeignClient的接口类
 */
//@Component
//public class CityApiRepositoryFallbackFactory implements FallbackFactory<CityApiRepository> {
//    @Override
//    public CityApiRepository create(Throwable cause) {
//        return new CityApiRepository() {
//            @Override
//            public String get(String id) {
//                return String.format("error:%s  %s", cause, id);
//            }
//        };
//    }
//}
@Component
@RequestMapping("cityfallback")
public class CityApiRepositoryFallback implements CityApiRepository {
    @Override
    public String get(String id) {
        return String.format("error %s", id);
    }
}


