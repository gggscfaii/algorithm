package com.wsd.algorithm.interview;

import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class lianhua {

//    select count(0) from (
//    select user_id from t_order where create_time>='2025-02-07' group by user_id having count(0)>1) t

    public static void main(String[] args) throws InterruptedException {

//        AtomicInteger sum = new AtomicInteger(100);
//
//        Object lock = new Object();
//        CountDownLatch countDownLatch = new CountDownLatch(10);
//        for (int i = 0; i < 10; i++) {
//            Thread thread = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    while (true) {
//                        synchronized (lock) {
//                            if (sum.get() <= 0) {
//                                break;
//                            }
//
//                            System.out.println(Thread.currentThread().getName() + "-" + sum.getAndDecrement());
//                            lock.notifyAll();
//                        }
//
//                        synchronized (lock) {
//                            try {
//                                lock.wait();
//                            } catch (InterruptedException e) {
//                                throw new RuntimeException(e);
//                            }
//                        }
//                    }
//
//                    countDownLatch.countDown();
//                }
//            });
//            thread.start();
//        }
//
//        countDownLatch.await();
//        System.out.println(sum.get());

        System.out.println(formatPrice(0.845699, 2));
    }

    public static String formatPrice(Double price, Integer scale) {
        BigDecimal bd = new BigDecimal(price);
        bd = bd.multiply(new BigDecimal(100));
        bd = bd.setScale(scale, BigDecimal.ROUND_HALF_UP);
        return bd.stripTrailingZeros().toPlainString() + "%";
    }

}
