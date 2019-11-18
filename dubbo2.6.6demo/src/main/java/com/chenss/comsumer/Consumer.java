package com.chenss.comsumer;

import com.chenss.api.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Consumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("dubbo-consumer.xml");

        classPathXmlApplicationContext.start();

        HelloService helloService = classPathXmlApplicationContext.getBean("helloService", HelloService.class);
        String chenss = helloService.sayHello("chenss");
        System.out.println(chenss);

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
