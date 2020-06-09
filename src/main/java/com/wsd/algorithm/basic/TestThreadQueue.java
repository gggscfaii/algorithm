package com.wsd.algorithm.basic;

import java.util.concurrent.*;

public class TestThreadQueue {

    public static void main(String[] args) {

        BlockingQueue<String> queue = new ArrayBlockingQueue<>(100);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        for (int i = 0; i < 10; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            String log = queue.take();
                            System.out.println(Thread.currentThread().getName() + ":" + log);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }

        System.out.println("begin:" + (System.currentTimeMillis() / 1000));
        for (int i = 0; i < 10; i++) {  //这行不能改动
            String input = i + "";  //这行不能改动
            String output = TestDo.doSome(input);
            queue.add(output);
            System.out.println(Thread.currentThread().getName() + ":" + output);
        }
    }


    //不能改动此TestDo类
    public static class TestDo {
        public static String doSome(String input) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String output = input + ":" + (System.currentTimeMillis() / 1000);
            return output;
        }
    }

}
