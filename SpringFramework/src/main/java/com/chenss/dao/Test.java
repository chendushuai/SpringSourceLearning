package com.chenss.dao;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        IndexService indexService = (IndexService) classPathXmlApplicationContext.getBean("service");
        indexService.service();
    }
}
