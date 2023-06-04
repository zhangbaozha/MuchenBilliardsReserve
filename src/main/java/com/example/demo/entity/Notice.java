package com.example.demo.entity;

import lombok.Data;

@Data
public class Notice {
    private Integer id;
    private String content;
    private String time;
    private String available;
}
