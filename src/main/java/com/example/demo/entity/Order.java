package com.example.demo.entity;

import lombok.Data;

@Data
public class Order {
    private Integer id;
    private String openID;
    private String tableNum;
    private String periodIndex;
    private String username;
    private String stuNum;
    private String phone;
    private String orderID;
    private String available;
    private String generateTime;
    private String addition;
    public Order(String openID, String tableNum, String periodIndex, String username, String stuNum, String phone, String orderID, String available, String generateTime, String addition) {
        this.openID = openID;
        this.tableNum = tableNum;
        this.periodIndex = periodIndex;
        this.username = username;
        this.stuNum = stuNum;
        this.phone = phone;
        this.orderID = orderID;
        this.available = available;
        this.generateTime = generateTime;
        this.addition = addition;
    }
}
