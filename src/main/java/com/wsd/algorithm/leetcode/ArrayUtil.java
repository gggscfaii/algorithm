package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/1/30.
 */
public class ArrayUtil {
    public static void print(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.print(nums[i][j] + ",");
            }
            System.out.println();
        }
    }

    public static void print(int[] ints) {
        for (int j = 0; j < ints.length; j++) {
            System.out.print(ints[j] + ",");
        }
        System.out.println();
    }
}
