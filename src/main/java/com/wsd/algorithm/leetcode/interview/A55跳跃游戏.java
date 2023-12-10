package com.wsd.algorithm.leetcode.interview;

public class A55跳跃游戏 {


    public static boolean canJump(int[] nums) {

        if (nums.length <= 1) {
            return true;
        }

        int minJumpIndex = -1;
        for (int i = nums.length - 2; i >= 0; i--) {


            if (minJumpIndex > 0) {
                if (nums[i] >= minJumpIndex - i) {
                    minJumpIndex = i;
                }
            } else {
                if (nums[i] >= nums.length - i - 1) {
                    minJumpIndex = i;
                }
            }
        }

        return minJumpIndex == 0;
    }

    public static void main(String[] args) {

        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));

        System.out.println(canJump(new int[]{0}));

        System.out.println(canJump(new int[]{3, 0, 8, 2, 0, 0, 1}));
    }
}
