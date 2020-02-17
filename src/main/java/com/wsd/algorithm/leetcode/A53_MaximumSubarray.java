package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/2/8.
 */
public class A53_MaximumSubarray {

    public static int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            if (sum < 0) {
                sum = num;
            } else {
                sum += num;
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
