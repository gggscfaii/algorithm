package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/1/26.
 */
public class A42_TrappingRainWater {
    public static int trap(int[] height) {
        if (height.length <= 1) {
            return 0;
        }

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int trap = 0;
        while (left < right) {
            if (height[left] > leftMax) {
                leftMax = height[left];
            }

            if (height[right] > rightMax) {
                rightMax = height[right];
            }

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }

            if (height[left] < leftMax && height[left] < rightMax) {
                trap += Math.min(leftMax, rightMax) - height[left];
            }

            if (height[right] < leftMax && height[right] < rightMax) {
                trap += Math.min(leftMax, rightMax) - height[right];
            }

        }

        return trap;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap(new int[]{4, 2, 3}));
    }

}
