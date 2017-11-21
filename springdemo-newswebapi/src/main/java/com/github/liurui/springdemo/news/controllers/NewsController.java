package com.github.liurui.springdemo.news.controllers;


import com.github.liurui.springdemo.news.entities.User;
import com.github.liurui.springdemo.news.services.UserService;
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
    UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public String create(@ApiParam(name = "userId", value = "用户编码", required = true)
                        @RequestParam
                                long userId,
                        @RequestBody
                        @ApiParam(name = "news", value = "新闻", required = true)
                                String  news) {
        User user = userService.get(userId);
        LOGGER.error("controller  {}" , user);
        return String.format("userid:%s name:%s news:%s" , user.getId(),user.getName(),news);
    }
}
