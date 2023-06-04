package com.example.demo.mapper;

import com.example.demo.entity.Order;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderMapper {
    @Update("insert into reserve_order (openID, tableNum, periodIndex, username, stuNum, phone, orderID,available,generateTime,addition) values (#{openID}, #{tableNum},#{periodIndex}, #{username},#{stuNum}, #{phone}, #{orderID}, #{available},#{generateTime},#{addition})")
    @Transactional
    void saveOrder(Order order);

    @Select("select * from reserve_order where openID=#{openID} and available = 'true'")
    List<Order> findByOpenID(String openID);

    @Update("update reserve_order set available =  #{newValue} where orderID = #{orderID}")
    void withdrawOrder(String orderID,String newValue);

    @Select("select * from reserve_order where orderID=#{orderID}")
    Order findByOrderID(String orderID);

    @Update("update reserve_order set available = 'false'")
    @Transactional
    void invalidateAllOrders();


    @Select("select * from reserve_order where tableNum=#{tableNum} and available = 'true'")
    List<Order> findByTableNum(Integer tableNum);

    @Select("select * from reserve_order where available = 'true'")
    List<Order> findAllAvailable();

}
