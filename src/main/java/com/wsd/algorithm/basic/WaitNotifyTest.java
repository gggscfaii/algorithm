package com.wsd.algorithm.basic;

/**
 * WaitNotifyTest
 *
 * @author wangshudong
 * @date 2020/8/10
 */
public class WaitNotifyTest {

    private static final Object LOCK = new Object();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (LOCK) {
                        try {
                            LOCK.wait();
                            System.out.println(finalI);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }

        Thread.sleep(10*1000L);
        synchronized (LOCK) {
            LOCK.notifyAll();
        }
    }
}
