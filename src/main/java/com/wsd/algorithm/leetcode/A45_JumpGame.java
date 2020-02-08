package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/1/29.
 */
public class A45_JumpGame {

    public static int jump(int[] nums) {
        int step = 0;
        int e = 0, max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == e) {
                step++;
                e = max;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 0, 1, 4}));
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(jump(new int[]{2, 2, 3, 1, 1, 4}));
    }
}
