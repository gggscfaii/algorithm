package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/2/9.
 */
public class A55_JumpGame {

    public static boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (max < i + 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
