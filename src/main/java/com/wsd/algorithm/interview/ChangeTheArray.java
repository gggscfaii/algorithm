package com.wsd.algorithm.interview;

import java.util.Arrays;

/**
 * ChangeTheArray
 *
 * @author wangshudong
 * @date 2021/5/17
 */
public class ChangeTheArray {

    /**
     * change the array
     *
     * @param arr int整型一维数组 the array
     * @return int整型一维数组
     */
    public static int[] change(int[] arr) {

        // write code here
        int evenIndex = 0, oddIndex = 1;
        int end = arr.length - 1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[end] % 2 == 0) {
                swap(arr, evenIndex, end);
                evenIndex += 2;
            }

            if (arr[end] % 2 == 1) {
                swap(arr, oddIndex, end);
                oddIndex += 2;
            }

            if (evenIndex >= end) {
                evenIndex = end;
            }

            if (oddIndex >= end) {
                oddIndex = end;
            }
        }

        return arr;
    }

    public static void swap(int[] arr, int s, int t) {
        int temp = arr[s];
        arr[s] = arr[t];
        arr[t] = temp;
    }

    public static void main(String[] args) {
        print(change(new int[]{1, 2, 3, 4, 5}));
        print(change(new int[]{1, 2, 3, 4, 6}));
    }

    private static void print(int[] change) {
        for (int i : change) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
