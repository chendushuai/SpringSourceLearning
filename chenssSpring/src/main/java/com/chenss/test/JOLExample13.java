package com.chenss.test;

import com.chenss.dao.A;
import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class JOLExample13 {
    static List<A> list = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);

        Thread t1 = new Thread() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    A a = new A();
                    synchronized (a) {
                        list.add(a);
                    }
                }
            }
        };
        t1.start();
        t1.join();
        out.println("before t2 0");
        out.println(ClassLayout.parseInstance(list.get(0)).toPrintable());
        out.println("before t2 list-2");
        out.println(ClassLayout.parseInstance(list.get(list.size()-2)).toPrintable());
        Thread t2 = new Thread() {
            int k = 0;
            public void run() {
                for (A a : list) {
                    synchronized (a) {
                        if (k==39) {
                            out.println("t2 ing k" + k);
                            out.println(ClassLayout.parseInstance(a).toPrintable());
                        }
                    }
                    k++;
                }
            }
        };
        t2.start();
        t2.join();
        Thread t3 = new Thread() {
            int k = 0;
            public void run() {
                for (A a : list) {
                    synchronized (a) {
                        if (k ==4 || k==19 || k==20 || k==39 || k==40 || k==70) {
                            out.println("t3 ing k" + k);
                            out.println(ClassLayout.parseInstance(a).toPrintable());
                        }
                    }
                    k++;
                }
            }
        };
        t3.start();
    }
}
