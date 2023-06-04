package com.example.demo.controller;

import com.example.demo.entity.Table;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.utils.Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/table")
public class TableController {
    @Resource
    OrderMapper orderMapper;
    public static Table table0 = new Table(0);
    public static Table table1 = new Table(1);
    public static Table table2 = new Table(2);
    public static Table table3 = new Table(3);
    public static Table table4 = new Table(4);
    public static List<Table> tableList = new ArrayList<>();
    {


        tableList.add(table0);
        tableList.add(table1);
        tableList.add(table2);
        tableList.add(table3);
        tableList.add(table4);

    }
    @GetMapping("/all")
    public List<Table> getTable(){
        Utils.initTable(orderMapper, TableController.table0);
        Utils.initTable(orderMapper, TableController.table1);
        Utils.initTable(orderMapper, TableController.table2);
        Utils.initTable(orderMapper, TableController.table3);
        Utils.initTable(orderMapper, TableController.table4);


        return tableList;
    }





}
