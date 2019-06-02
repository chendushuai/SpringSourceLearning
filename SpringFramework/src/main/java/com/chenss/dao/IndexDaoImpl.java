package com.chenss.dao;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository("dao")
@Scope("prototype")
public class IndexDaoImpl implements IndexDao {
    @Override
    public void test() {
        System.out.println("impl ");
    }
    public IndexDaoImpl() {
        System.out.println("Contructor");
    }
    @PostConstruct
    public void init() {
        System.out.println("init");
    }
}
