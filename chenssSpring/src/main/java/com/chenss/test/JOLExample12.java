package com.chenss.test;

import com.chenss.dao.A;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class JOLExample12 {
    static List<A> list = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);

        Thread t1 = new Thread() {
            public void run() {
                for (int i = 0; i < 30; i++) {
                    A a = new A();
                    synchronized (a) {
                        out.println("sdfsf");
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
                        if (k ==4) {
                            out.println("t2 ing k4");
                            out.println(ClassLayout.parseInstance(a).toPrintable());
                        }
                        if (k ==list.size()-2) {
                            out.println("t2 ing k-2");
                            out.println(ClassLayout.parseInstance(a).toPrintable());
                        }
                        if (k ==20) {
                            out.println("t2 ing k20");
                            out.println(ClassLayout.parseInstance(a).toPrintable());
                        }
                        if (k ==18) {
                            out.println("t2 ing k18");
                            out.println(ClassLayout.parseInstance(a).toPrintable());
                        }
                    }
                    k++;
                }
            }
        };
        t2.start();
    }
}
