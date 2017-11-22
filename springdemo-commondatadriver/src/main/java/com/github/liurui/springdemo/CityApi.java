package com.github.liurui.springdemo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Api(tags = "城市", description = "城市基本操作")
@RequestMapping(path = "/city")
public interface CityApi {
    @ApiOperation(value = "获取城市名称", notes = "获取城市名称",consumes = "application/json")
    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "编号", paramType = "path", required = true)
    })
    String get(@PathVariable("id") String id);
}