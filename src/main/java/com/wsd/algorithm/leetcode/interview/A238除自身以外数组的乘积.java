package com.wsd.algorithm.leetcode.interview;

import com.wsd.algorithm.leetcode.ArrayUtil;

public class A238除自身以外数组的乘积 {

    public static int[] productExceptSelf(int[] nums) {

        int[] leftAnswer = new int[nums.length];
        leftAnswer[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            leftAnswer[i] = leftAnswer[i - 1] * nums[i - 1];
        }

        int[] rightAnswer = new int[nums.length];
        rightAnswer[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            rightAnswer[i] = rightAnswer[i + 1] * nums[i + 1];
        }

        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            answer[i] = leftAnswer[i] * rightAnswer[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        ArrayUtil.print(productExceptSelf(new int[]{1, 2, 3, 4}));
        ArrayUtil.print(productExceptSelf(new int[]{-1, 1, 0, -3, 3}));
    }
}
