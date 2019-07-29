package com.chenss.lock;

import com.chenss.dao.A;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    static A a;

    public static void main(String[] args) throws InterruptedException {
        a = new A();
        final ReentrantLock lock = new ReentrantLock(true);

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println("threadA Locked");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        });
        threadA.setName("threadA");
        threadA.start();

        Thread.sleep(500);

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println("threadB Locked");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        });
        threadB.setName("threadB");
        threadB.start();

        Thread.sleep(500);

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println("threadC Locked");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        });
        threadC.setName("threadC");
        threadC.start();

        Thread.sleep(500);

        Thread threadD = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println("threadD Locked");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        });
        threadD.setName("threadD");
        threadD.start();
    }
}
