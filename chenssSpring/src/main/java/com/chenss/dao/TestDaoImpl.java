package com.chenss.dao;

public class TestDaoImpl implements TestDao {
    private String name;
    public TestDaoImpl(String name) {
        this.name = name;
    }
    @Override
    public void query() {
        System.out.println("TestDaoImpl query " + name);
    }
}
