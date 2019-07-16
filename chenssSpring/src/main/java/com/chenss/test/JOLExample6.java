package com.chenss.test;

import com.chenss.dao.A;
import org.openjdk.jol.info.ClassLayout;

public class JOLExample6 {
    static A a;
    public static void main(String[] args) {
        try {
            Thread.sleep(4500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a = new A();

        System.out.println(a.hashCode());
        System.out.println("befor");
        System.out.println(ClassLayout.parseInstance(a).toPrintable());//偏向锁
        synchronized (a) {
            System.out.println("lock ing");
            System.out.println(ClassLayout.parseInstance(a).toPrintable());//偏向锁
        }
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100000; j++) {
                        synchronized (a) {
                        }
                    }
                }
            }).start();
        }
        System.out.println("lock lock");
        System.out.println(ClassLayout.parseInstance(a).toPrintable());//重量级锁
        a.parse();
        System.gc();
        System.out.println("gc mark");
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
    }
}
