package com.wsd.algorithm.leetcode.interview;

public class A42接雨水 {

    public static int trap(int[] height) {

        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 1; i < n - 1; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }

        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }

        int water = 0;
        for (int i = 0; i < n; i++) {
            water += Math.max(0, Math.min(left[i], right[i]) - height[i]);
        }
        return water;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap(new int[]{4, 2, 0, 3, 2, 5}));
    }
}
