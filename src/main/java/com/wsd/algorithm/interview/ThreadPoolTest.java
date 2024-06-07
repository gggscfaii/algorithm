package com.wsd.algorithm.interview;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author sdwang
 * @date 2024/6/7
 */
public class ThreadPoolTest {

    public static final ThreadPoolExecutor threadPoolExecutor =
            new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS,
                    new LinkedBlockingDeque<>(10));

    public static void main(String[] args) {

        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                CountDownLatch latch = new CountDownLatch(3);
                for (int i = 0; i < 3; i++) {
                    threadPoolExecutor.execute(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("执行子线程");
                            latch.countDown();
                        }
                    });
                    System.out.println("主线程执行开始");
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("主线程执行结束");
                }
            }
        });
    }

}
