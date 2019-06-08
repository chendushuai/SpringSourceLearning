package com.chenss.test;

import com.chenss.config.Spring;
import com.chenss.dao.IndexDao;
import com.chenss.dao.IndexDaoImpl;
import com.chenss.dao.IndexDaoTest;
import com.chenss.service.IndexService;
import com.chenss.service.TestIndexService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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

        //JDK动态代理，代理出来的对象已经继承了Proxy类，且JDK底层是单继承的，所以无法再继承指定类，只能是实现某一接口。
        /*Class<?>[] interfaces = new Class[]{IndexDao.class};
        byte bytes[] = ProxyGenerator.generateProxyClass("Chenss", interfaces);
        File file = new File("d:\\Chenss.class");
        try {
            FileOutputStream outputStream = new FileOutputStream(file);

            outputStream.write(bytes);
            outputStream.flush();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
