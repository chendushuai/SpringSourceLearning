package com.chenss.dao;

import com.chenss.anno.Chenss;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Chenss
public class IndexDaoTest {
    public void test(String name,int age) {
        System.out.println(name + " - " + age);
    }
}
