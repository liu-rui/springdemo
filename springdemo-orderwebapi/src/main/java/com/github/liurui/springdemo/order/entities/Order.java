package com.github.liurui.springdemo.order.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "订单")
public class Order {

    @ApiModelProperty(notes = "订单编码")
    private long id;
    @ApiModelProperty(notes = "用户编码")
    private long userId;
    @ApiModelProperty(notes = "用户名")
    private String UserName;
    @ApiModelProperty(notes = "金额")
    private float amount;

    public Order() {
    }

    public Order(long id, long userId, String userName, float amount) {
        this.id = id;
        this.userId = userId;
        UserName = userName;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", UserName='" + UserName + '\'' +
                ", amount=" + amount +
                '}';
    }
}
