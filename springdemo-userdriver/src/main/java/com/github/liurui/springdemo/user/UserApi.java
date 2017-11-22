package com.github.liurui.springdemo.user;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/user")
@Api(tags = "用户", description = "用户基本操作")
public interface UserApi {
    @RequestMapping(path = "info/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "根据用户编码获取信息", notes = "根据用户编码获取信息")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "id", value = "用户编码", paramType = "path")
    })
    User info(@PathVariable("id") long id);

    @RequestMapping(path = "login", method = RequestMethod.GET)
    @ApiOperation(value = "登录", notes = "登录")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "name", value = "登录名", paramType = "query"),
            @ApiImplicitParam(required = true, name = "password", value = "密码", paramType = "query")
    })
    String login(@RequestParam("name") String name, @RequestParam("password") String password);
}