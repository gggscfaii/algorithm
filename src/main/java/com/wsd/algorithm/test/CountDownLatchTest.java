package com.wsd.algorithm.test;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(2);

        new Thread(() -> {

            try {
                Thread.sleep(1000);

                latch.countDown();
                latch.countDown();

                System.out.println(System.currentTimeMillis() + ":线程1执行完毕");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {

            try {
                Thread.sleep(5000);

                latch.countDown();

                System.out.println(System.currentTimeMillis() + ":线程2执行完毕");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        try {
            latch.await();
            System.out.println(System.currentTimeMillis() + ":主线程执行完毕");
        } catch (Exception e) {
        }

    }
}
