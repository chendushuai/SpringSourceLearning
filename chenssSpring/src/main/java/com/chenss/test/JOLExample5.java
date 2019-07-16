package com.chenss.test;

import com.chenss.dao.A;
import org.openjdk.jol.info.ClassLayout;

public class JOLExample5 {
    static A a;
    public static void main(String[] args) {
        a = new A();

        System.out.println(a.hashCode());
        System.out.println("before lock");
        System.out.println(ClassLayout.parseInstance(a).toPrintable());//偏向锁
        synchronized (a) {
            System.out.println("lock ing");
            System.out.println(ClassLayout.parseInstance(a).toPrintable());//重量级锁
        }
        System.out.println("after lock");
        System.out.println(ClassLayout.parseInstance(a).toPrintable());//重量级锁
    }
}
