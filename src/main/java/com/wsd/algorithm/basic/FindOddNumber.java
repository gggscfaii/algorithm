package com.wsd.algorithm.basic;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * FindOddNumber
 *
 * @author wangshudong
 * @date 2021/3/16
 */
public class FindOddNumber {

    public static void main(String[] args) {

        int[] array = {4, 8, 4, 10, 2, 4, 4, 2};

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum ^= array[i];
        }

        int bit = 1;
        while ((sum & bit) == 0) {
            bit = bit << 1;
        }

        int an1 = 0, an2 = 0;
        List<Integer> a1s = Lists.newArrayList();
        List<Integer> a2s = Lists.newArrayList();

        for (int i = 0; i < array.length; i++) {
            if ((array[i] & bit) > 0) {
                an1 ^= array[i];
                a1s.add(array[i]);
            } else {
                an2 ^= array[i];
                a2s.add(array[i]);
            }
        }

        System.out.printf("%s,%s\n", an1, an2);

        System.out.println(a1s);
        System.out.println(a2s);
    }
}
