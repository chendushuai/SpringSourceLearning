package com.chenss.dao;

public class IndexDaoImpl implements IndexDao {
    private String str;
    @Override
    public void test() {
        System.out.println("impl " + str);
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}