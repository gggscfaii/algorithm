package com.wsd.algorithm.basic;

/**
 * TestTime
 *
 * @author wangshudong
 * @date 2021/3/12
 */
public class TestTime {

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        Thread.sleep(500);

        System.out.println(System.currentTimeMillis() - start);
    }
}
