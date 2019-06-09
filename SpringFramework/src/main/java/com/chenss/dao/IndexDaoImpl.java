package com.chenss.dao;

import com.chenss.anno.Chenss;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Repository("dao1")
@Chenss
@Scope("prototype")
public class IndexDaoImpl implements IndexDao {
    @Override
    public void test() {
        System.out.println("impl ");
    }
    @Override
    public void test(String args) {
        System.out.println("impl " + args);
    }
    public IndexDaoImpl() {
        //System.out.println("Contructor");
    }
}
