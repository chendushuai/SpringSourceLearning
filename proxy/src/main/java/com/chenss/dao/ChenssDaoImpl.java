package com.chenss.dao;

public class ChenssDaoImpl implements ChenssDao {
    public String query() {
        System.out.println("假装查询数据库");
        return "query()";
    }

    @Override
    public int query(String name) {
        System.out.println("name " + name);
        return 2;
    }

    @Override
    public void query(String name, int age) {
        System.out.println("name " + name + " ; age " + age);
    }
}
