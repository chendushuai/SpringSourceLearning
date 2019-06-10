package com.chenss.entity;

public class IndexDao implements Dao {
    @Override
    public void query() {
        System.out.println("IndexDao Impl");
    }

    @Override
    public void query(String name) {
        System.out.println("IndexDao query name " + name);
    }
}
