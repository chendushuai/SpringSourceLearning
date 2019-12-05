package com.chenss.test;

import com.chenss.properties.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesTest {
    @Autowired
    Student student;

    @Value("${name}")
    String name;
    @Value("${age}")
    int age;

    @Test
    public void readTest(){
        System.out.println(student);

        System.out.println("name= " + name + "   age:   " + age);
    }
}
