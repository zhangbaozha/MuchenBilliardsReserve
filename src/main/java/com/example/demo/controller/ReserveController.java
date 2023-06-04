package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Order;

import com.example.demo.mapper.OrderMapper;
import com.example.demo.utils.Utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/reserve")
@Slf4j
public class ReserveController {
    @Resource
    OrderMapper orderMapper;


    @PostMapping()
    @ResponseBody
    public int Reserve(@RequestBody JSONObject jsonParam){

        Map<String,Object> map =new HashMap<>();
        //开始转换
        Iterator it =jsonParam.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> entry = (Map.Entry<String, Object>) it.next();
            map.put(entry.getKey(), entry.getValue());
        }


        String code = (String) map.get("code");
        String openid = Utils.getOpenID(code);
        System.out.println("openid:"+openid);



        String tableNum = (String) map.get("tableNum");
        String periodIndex = (String) map.get("periodIndex");
        String username = (String) map.get("username");
        String stuNum = (String) map.get("stuNum");
        String phone = (String) map.get("phone");
        String addition = (String) map.get("addition");
        String orderID = UUID.randomUUID().toString();
        String available = "true";

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String generateTime = formatter.format(date);

        Order order = new Order(openid, tableNum, periodIndex, username, stuNum, phone, orderID, available,generateTime,addition);

        int Num = Integer.parseInt(tableNum);
        int index = Integer.parseInt(periodIndex);


        List<Order> byOpenID = orderMapper.findByOpenID(openid);
        if (byOpenID.size() > 2){
            System.out.println("当日订单过多");
            log.info("用户："+ username +"openid:"+openid+ "预约" + tableNum +"号台"+periodIndex+"时间段" + "失败，当日预约次数过多");
            return 2;
        }
        else {
            int res = Utils.setTableBusy(Num, index, orderID);
            if(res == 0){
                return res;
            }
            orderMapper.saveOrder(order);
            log.info("用户："+ username +"openid:"+openid+ "成功预约" + tableNum +"号台"+periodIndex+"时间段");
            return 1;
        }






    }




}
