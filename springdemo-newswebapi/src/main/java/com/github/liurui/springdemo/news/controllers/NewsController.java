package com.github.liurui.springdemo.news.controllers;


import com.github.liurui.springdemo.news.repositories.CityApiRepository;
import com.github.liurui.springdemo.news.repositories.UserApiRepository;
import com.github.liurui.springdemo.user.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = {"新闻"}, description = "新闻基本操作")
@RequestMapping("/news")
public class NewsController {
    public static final Logger LOGGER = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    UserApiRepository userApiRepository;

    @Autowired
    CityApiRepository cityApiRepository;

    @RequestMapping(method = RequestMethod.POST)
    public String create(@ApiParam(name = "userId", value = "用户编码", required = true)
                         @RequestParam
                                 long userId,
                         @RequestBody
                         @ApiParam(name = "news", value = "新闻", required = true)
                                 String news) {
        User user = userApiRepository.info(userId);
        LOGGER.error("controller  {}", user);
        LOGGER.error("controller  {}", userApiRepository.login("sd", "sdd"));
        String city = cityApiRepository.get(String.valueOf(userId));
        LOGGER.error("controller  {}", city);
        return city;
//        return city;
//        return String.format("userid:%s name:%s news:%s city:%s", user.getId(), user.getName(), news , city);
    }
}
