package com.chenss.dao;

public class DaoIndex {
    private String param;
    public DaoIndex(String param) {
        this.param=param;
    }
    public void strQuery() {
        System.out.println(this.param);
        System.out.println("dao");
    }
}
