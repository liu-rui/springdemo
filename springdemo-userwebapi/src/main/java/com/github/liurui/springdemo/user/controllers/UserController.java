package com.github.liurui.springdemo.user.controllers;

import com.github.liurui.springdemo.user.entities.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "用户", description = "用户基本操作")
@RequestMapping(path = "/user")
public class UserController {
    public static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    DiscoveryClient discoveryClient;

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    @ApiOperation(value = "根据用户编码获取信息", notes = "根据用户编码获取信息")
    public User get(@PathVariable
                    @ApiParam(required = true, name = "id", value = "用户编码")
                            String id) {
        for (String serviceId : discoveryClient.getServices()) {
            List<ServiceInstance> clientInstances = discoveryClient.getInstances(serviceId);
            LOGGER.error("{} {}", serviceId, clientInstances.size());
            for (ServiceInstance clientInstance : clientInstances) {
                LOGGER.error("--{}:{} {} {}", clientInstance.getHost(), clientInstance.getPort(), clientInstance.getServiceId(), clientInstance.getUri());
                for (Map.Entry<String, String> entry : clientInstance.getMetadata().entrySet()) {
                    LOGGER.error("----{}:{}", entry.getKey(), entry.getValue());
                }
            }
        }
        return new User(1, "刘锐");
    }
}
