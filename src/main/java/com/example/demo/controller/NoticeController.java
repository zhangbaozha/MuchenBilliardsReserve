package com.example.demo.controller;

import com.example.demo.entity.Notice;
import com.example.demo.entity.Order;
import com.example.demo.mapper.NoticeMapper;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/notice")
@Slf4j
public class NoticeController {
    @Resource
    NoticeMapper noticeMapper;
    @GetMapping("/all")
    public List<Notice> getAllNotice(){

        return noticeMapper.findAllNotice();

    }
}
