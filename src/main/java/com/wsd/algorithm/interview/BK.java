package com.wsd.algorithm.interview;

public class BK {

    public static void main(String[] args) throws InterruptedException {

        byte[] b = new byte[200 * 1024 * 1024];
        byte[] b1 = new byte[200 * 1024 * 1024];

        for (int i = 0; i < 100; i++) {
//            System.out.println("123");
            Thread thread = new Thread(BK::largeObject);
            thread.start();
        }

        Thread.sleep(100 * 1000);

    }

    private static void largeObject() {
        Test test = new Test();
    }

    public static class Test {
        byte[] b = new byte[256 * 1024 * 1024];
    }
}
