package com.chenss.test;

import com.chenss.entity.Dao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        Dao dao = (Dao) classPathXmlApplicationContext.getBean("indexDao");
        dao.query();
        System.out.println("-----------------------------------");
        dao.query("chenss");
    }
}
