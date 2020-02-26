package com.wsd.algorithm.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

/**
 * SplitTaskTest
 * Created by sdwang on 2020/2/26 9:23.
 */
public class SplitTaskTest {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(100);
        CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {

                while (true) {
                    try {
                        Integer take = queue.take();
                        System.out.println(take);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        latch.countDown();
                    }
                }
            });
            t.start();
        }

        List<Integer> tasks = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            tasks.add(i);
        }
        for (int i = 0; i < 10; i++) {
            List<Integer> subTasks = tasks.subList(i * 10, (i + 1) * 10);
            queue.addAll(subTasks);
            latch.await();
        }
    }
}
