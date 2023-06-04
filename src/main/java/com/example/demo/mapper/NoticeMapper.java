package com.example.demo.mapper;

import com.example.demo.entity.Notice;
import com.example.demo.entity.Order;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface NoticeMapper {
    @Select("select * from notice where available = 'true'")
    List<Notice> findAllNotice();
}
