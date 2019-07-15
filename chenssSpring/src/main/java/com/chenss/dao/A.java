package com.chenss.dao;

public class A {
    int i = 0;
    boolean flag = false;
    public synchronized void parse() {
        i++;
    }
}
