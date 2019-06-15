package com.chenss.dao;

public class UserDaoImpl implements UserDao {
    public void query() {
        System.out.println("假装查询数据库");
    }

    @Override
    public void query(String name) {
        System.out.println("name " + name);
    }

    @Override
    public void query(String name, int age) {
        System.out.println("name " + name + " ; age " + age);
    }
}
