package com.wsd.algorithm.interview;

import java.util.Arrays;

/**
 * Candy
 *
 * @author wangshudong
 * @date 2021/5/25
 */
public class Candy {

    public static int candy(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int[] l = new int[arr.length];
        Arrays.fill(l, 1);

        int[] r = new int[arr.length];
        Arrays.fill(r, 1);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) l[i] += l[i - 1];
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) r[i] += r[i + 1];
        }

        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            s += Math.max(l[i], r[i]);
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(candy(new int[]{1, 1, 2, 3}));
        System.out.println(candy(new int[]{5, 1, 2, 3}));
    }
}
