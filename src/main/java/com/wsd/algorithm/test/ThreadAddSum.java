package com.wsd.algorithm.test;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadAddSum {

    public static void main(String[] args) {

        AtomicInteger sum = new AtomicInteger();

        Object lock = new Object();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        synchronized (lock) {
                            if (sum.get() >= 100) {
                                lock.notify();
                                break;
                            }
                            sum.incrementAndGet();
                            System.out.println(Thread.currentThread().getName() + ":" + sum);
                        }
                    }
                }
            }).start();
        }

        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        // Scanner input=new Scanner(System.in);
        // String str=input.next();
        System.out.println("hello world");
    }

}
