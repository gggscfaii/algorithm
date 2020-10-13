package com.wsd.algorithm.basic;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.function.Supplier;

/**
 * CyclicBarrier
 *
 * @author wangshudong
 * @date 2020/10/13
 */
public class CyclicBarrierTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(100);
        // CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        // for (int i = 0; i < 10; i++) {
        //     Thread thread = new Thread(new Runnable() {
        //         @Override
        //         public void run() {
        //             try {
        //                 while (true) {
        //                     cyclicBarrier.await();
        //                     System.out.println(System.currentTimeMillis() / 1000 + ":" + queue.take());
        //                     Thread.sleep(new Random().nextInt(1000));
        //                 }
        //             } catch (InterruptedException e) {
        //                 e.printStackTrace();
        //             } catch (BrokenBarrierException e) {
        //                 e.printStackTrace();
        //             } finally {
        //                 // latch.countDown();
        //             }
        //         }
        //     });
        //     thread.start();
        // }
        //
        // for (int i = 0; i < 100; i++) {
        //     queue.put(i);
        // }

        // for (int j = 0; j < 10; j++) {
        //     CompletableFuture<Void>[] futures = new CompletableFuture[10];
        //     for (int i = 0; i < 10; i++) {
        //         int finalJ = j * 10 + i;
        //
        //         futures[i] = new CompletableFuture<>();
        //         futures[i].thenRun(new Runnable() {
        //             @Override
        //             public void run() {
        //                 try {
        //                     Thread.sleep(new Random().nextInt(2000));
        //                 } catch (InterruptedException e) {
        //                     e.printStackTrace();
        //                 }
        //                 System.out.println(System.currentTimeMillis() / 1000 + ":" + finalJ);
        //             }
        //         });
        //     }
        //     CompletableFuture.allOf(futures).join();
        //     System.out.println("__________________");
        // }

        List<Integer> nums = Lists.newArrayList();
        nums.add(1);
        nums.add(2);

        System.out.println(nums.retainAll(Lists.newArrayList(2, 3)));
        System.out.println(nums);
    }
}
