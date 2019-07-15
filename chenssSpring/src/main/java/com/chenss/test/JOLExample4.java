package com.chenss.test;

import com.chenss.dao.A;

public class JOLExample4 {
    public static void main(String[] args) {
        A a = new A();

        long start = System.currentTimeMillis();

        for (long j = 0; j < 10000000L; j++) {
            a.parse();
        }
        long end = System.currentTimeMillis();

        System.out.println(String.format("%sms" , end - start));
    }
}
