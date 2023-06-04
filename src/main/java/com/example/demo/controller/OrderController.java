package com.example.demo.controller;

import com.example.demo.entity.Order;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Resource
    OrderMapper orderMapper;
    @GetMapping("/all")
    public List<Order> getAllOrder(String code){
        System.out.println(code);
        String openID = Utils.getOpenID(code);

        return orderMapper.findByOpenID(openID);

    }


    @PostMapping("/withdraw")
    public void withdrawOrder(String orderID){
        System.out.println(orderID);
        orderMapper.withdrawOrder(orderID,"false");
        Order order = orderMapper.findByOrderID(orderID);
        int tableNum = Integer.parseInt(order.getTableNum());
        int periodIndex = Integer.parseInt(order.getPeriodIndex());
        Utils.setTableFree(tableNum,periodIndex);
        log.info("撤销预约"+orderID);
    }

    @GetMapping("/admin-all")
    public List<Order> adminCheck(){

        return orderMapper.findAllAvailable();
    }
}
