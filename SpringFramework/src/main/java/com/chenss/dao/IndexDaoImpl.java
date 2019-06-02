package com.chenss.dao;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Repository
public class IndexDaoImpl implements IndexDao {
    @Override
    public void test() {
        System.out.println("impl ");
    }
    public IndexDaoImpl() {
        System.out.println("Contructor");
    }
}
