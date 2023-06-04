package com.example.demo.controller;

import com.example.demo.mapper.OrderMapper;
import com.example.demo.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
public class TimeController {
    @Resource
    OrderMapper orderMapper;

    @Scheduled(cron="0 00 23 ? * *")
    public void clear(){
        orderMapper.invalidateAllOrders();
        Utils.setAllTableFree();
        log.info("定时任务启动，刷新球桌状态");
    }
}
