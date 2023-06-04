package com.example.demo.utils;

import com.example.demo.controller.TableController;
import com.example.demo.entity.Order;
import com.example.demo.entity.Table;
import com.example.demo.mapper.OrderMapper;
import com.github.kevinsawicki.http.HttpRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Utils {



    public static String getOpenID(String code){
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        HashMap<String, String> data= new HashMap<>();
        data.put("appid", "wxe446ca349a653042");
        data.put("secret","ac9e2b3f0128d9e3efa368a790a15625");
        data.put("js_code",code);
        data.put("grant_type","authorization_code");
        String body = HttpRequest.get("https://api.weixin.qq.com/sns/jscode2session").form(data).body();
        return body.split(":\"")[2].split("\"}")[0];
    }
    public static void setTableFree(int tableNum, int periodIndex){

        if(tableNum == 0){
            ArrayList<String> periodList = (ArrayList<String>) TableController.table0.getPeriod();
            periodList.set(periodIndex,"");
            TableController.table0.setPeriod(periodList);
        }
        if(tableNum == 1){
            ArrayList<String> periodList = (ArrayList<String>) TableController.table1.getPeriod();
            periodList.set(periodIndex,"");
            TableController.table1.setPeriod(periodList);
        }
        if(tableNum == 2){
            ArrayList<String> periodList = (ArrayList<String>) TableController.table2.getPeriod();
            periodList.set(periodIndex,"");
            TableController.table2.setPeriod(periodList);
        }
        if(tableNum == 3){
            ArrayList<String> periodList = (ArrayList<String>) TableController.table3.getPeriod();
            periodList.set(periodIndex,"");
            TableController.table3.setPeriod(periodList);
        }
        if(tableNum == 4){
            ArrayList<String> periodList = (ArrayList<String>) TableController.table4.getPeriod();
            periodList.set(periodIndex,"");
            TableController.table4.setPeriod(periodList);
        }
    }
    public static void setAllTableFree(){
        ArrayList<String> sites0 = new ArrayList<String>();
        ArrayList<String> sites1 = new ArrayList<String>();
        ArrayList<String> sites2 = new ArrayList<String>();
        ArrayList<String> sites3 = new ArrayList<String>();
        ArrayList<String> sites4 = new ArrayList<String>();
        for(int i=0; i<12;i++){
            sites0.add("");
            sites1.add("");
            sites2.add("");
            sites3.add("");
            sites4.add("");
        }


        TableController.table0.setPeriod(sites0);
        TableController.table1.setPeriod(sites1);
        TableController.table2.setPeriod(sites2);
        TableController.table3.setPeriod(sites3);
        TableController.table4.setPeriod(sites4);

    }
    public static int setTableBusy(int tableNum, int periodIndex, String orderID){
        if(tableNum == 0){
            ArrayList<String> periodList = (ArrayList<String>) TableController.table0.getPeriod();
            if(Objects.equals(periodList.get(periodIndex), "")) {
                periodList.set(periodIndex, orderID);
                TableController.table0.setPeriod(periodList);
                return 1;
            }
            return 0;
        }
        if(tableNum == 1){
            ArrayList<String> periodList = (ArrayList<String>) TableController.table1.getPeriod();
            if(Objects.equals(periodList.get(periodIndex), "")) {
                periodList.set(periodIndex, orderID);
                TableController.table1.setPeriod(periodList);
                return 1;
            }
            return 0;
        }
        if(tableNum == 2){
            ArrayList<String> periodList = (ArrayList<String>) TableController.table2.getPeriod();
            if(Objects.equals(periodList.get(periodIndex), "")) {
                periodList.set(periodIndex, orderID);
                TableController.table2.setPeriod(periodList);
                return 1;
            }
            return 0;
        }
        if(tableNum == 3){
            ArrayList<String> periodList = (ArrayList<String>) TableController.table3.getPeriod();
            if(Objects.equals(periodList.get(periodIndex), "")) {
                periodList.set(periodIndex, orderID);
                TableController.table3.setPeriod(periodList);
                return 1;
            }
            return 0;
        }
        if(tableNum == 4){
            ArrayList<String> periodList = (ArrayList<String>) TableController.table4.getPeriod();
            if(Objects.equals(periodList.get(periodIndex), "")) {
                periodList.set(periodIndex, orderID);
                TableController.table4.setPeriod(periodList);
                return 1;
            }
            return 0;
        }
        return 0;
    }

    public static void initTable(OrderMapper orderMapper, Table table) {
        List<Order> orders = orderMapper.findByTableNum(table.getTableNum());
        for(Order order :orders){
            int periodIndex = Integer.parseInt(order.getPeriodIndex());
            Utils.setTableBusy(table.getTableNum(),periodIndex,order.getOrderID());
        }

    }

}
