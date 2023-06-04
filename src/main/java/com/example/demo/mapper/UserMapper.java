package com.example.demo.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    List<User> findAll();

    @Update("insert into user (username, age) values (#{username}, #{age})")
    @Transactional
    void saveUser(User user);

    @Update("update user set username=#{username}, age=#{age} where id=#{id}")
    void updateById(User user);
}
