package com.wsd.algorithm.test4;

import java.util.Random;

public class ZjTest {

    public static void main(String[] args) {

        Random r = new Random();
        for (int i = 0; i < 10000; i++) {
            System.out.println(r.nextInt(100000));
        }
    }
}
