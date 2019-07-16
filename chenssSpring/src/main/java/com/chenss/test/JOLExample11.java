package com.chenss.test;

import com.chenss.dao.A;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import static java.lang.System.out;

public class JOLExample11 {
    static A a;

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        a = new A();
        out.println("befre lock");
        out.println(VM.current().details());
        out.println(ClassLayout.parseInstance(a).toPrintable());

        Thread t1 = new Thread() {
            public void run() {
                synchronized (a) {
                    try {
                        synchronized (a) {
                            System.out.println("before wait");
                            out.println(ClassLayout.parseInstance(a).toPrintable());
                            a.wait();
                            System.out.println(" after wait");
                            out.println(ClassLayout.parseInstance(a).toPrintable());
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();
        Thread.sleep(5000);
        synchronized (a) {
            a.notifyAll();
        }
    }
}
