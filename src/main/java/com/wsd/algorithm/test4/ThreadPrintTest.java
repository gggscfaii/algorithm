package com.wsd.algorithm.test4;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPrintTest {

    public static void main(String[] args) {

        AtomicInteger count = new AtomicInteger(0);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new PrintClass(count, 10, i));
            thread.setName("ThreadPrintTest-" + i);
            thread.start();
        }
    }

    public static class PrintClass implements Runnable {

        private static final Object LOCK = new Object();

        private final int flag;
        private final AtomicInteger count;
        private final int totalThreadCount;

        public PrintClass(AtomicInteger count,
                          int totalThreadCount,
                          int flag) {
            this.flag = flag;
            this.totalThreadCount = totalThreadCount;
            this.count = count;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    synchronized (LOCK) {
                        while (count.get() % totalThreadCount != flag) {
                            LOCK.wait();
                        }

                        if (count.get() >= 1000) {
                            break;
                        }
                        System.out.println(Thread.currentThread().getName() + ": " + count.incrementAndGet());
                        LOCK.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
