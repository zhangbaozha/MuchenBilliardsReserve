package com.example.demo.entity;

import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private Integer tableNum;
    private List<String> period;

    public Integer getTableNum() {
        return tableNum;
    }

    public void setTableNum(Integer tableNum) {
        this.tableNum = tableNum;
    }

    public List<String> getPeriod() {
        return period;
    }

    public void setPeriod(List<String> period) {
        this.period = period;
    }

    public Table(Integer tableNum) {
        this.tableNum = tableNum;

        ArrayList<String> sites = new ArrayList<String>();
        sites.add("");
        sites.add("");
        sites.add("");

        sites.add("");
        sites.add("");
        sites.add("");

        sites.add("");
        sites.add("");
        sites.add("");

        sites.add("");
        sites.add("");
        sites.add("");
        this.period = sites;
    }
}
