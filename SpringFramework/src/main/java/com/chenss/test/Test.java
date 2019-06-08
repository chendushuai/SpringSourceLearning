package com.chenss.test;

import com.chenss.config.Spring;
import com.chenss.dao.IndexDao;
import com.chenss.dao.IndexDaoImpl;
import com.chenss.dao.IndexDaoTest;
import com.chenss.service.IndexService;
import com.chenss.service.TestIndexService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        //ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        //IndexService indexService = (IndexService) classPathXmlApplicationContext.getBean("indexService");
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Spring.class);

        IndexDaoTest indexDao = annotationConfigApplicationContext.getBean(IndexDaoTest.class);
        indexDao.test("chenss",29);

        /*annotationConfigApplicationContext.getEnvironment().setActiveProfiles("dao1");
        annotationConfigApplicationContext.register(Spring.class);
        annotationConfigApplicationContext.refresh();
        System.out.println("className: " + annotationConfigApplicationContext.getBean(IndexDao.class).getClass().getSimpleName());*/
        /*IndexService indexService = (IndexService) annotationConfigApplicationContext.getBean("indexService");
        indexService.service();*/
        /*TestIndexService testIndexService = (TestIndexService) annotationConfigApplicationContext.getBean("testIndexService");
        System.out.println(testIndexService.getClass().getSimpleName());*/
    }
}
