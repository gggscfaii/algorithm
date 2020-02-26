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

    public static int trap1(int[] height) {

        int n = height.length;

        if (n == 0 || n == 1) {
            return 0;
        }

        int[] left_max = new int[n];
        int[] right_max = new int[n];

        left_max[0] = height[0];
        right_max[n - 1] = height[n - 1];

        for (int i = 1; i < n; ++i) {
            left_max[i] = Math.max(left_max[i - 1], height[i]);
        }

        //System.out.println("Left_max array : " + Arrays.toString(left_max));

        for (int i = n - 2; i > -1; --i) {
            right_max[i] = Math.max(right_max[i + 1], height[i]);
        }

        //System.out.println("right_max array : " + Arrays.toString(right_max));

        int total_water = 0;
        int current_water = 0;

        for (int i = 1; i < n - 1; ++i) {
            current_water = Math.min(left_max[i], right_max[i]) - height[i];
            //System.out.println("at index : " + i + " " + current_water);
            total_water += current_water;

            /*if(current_water > 0){
                total_water += current_water;
            }*/
        }

        return total_water;

    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap(new int[]{4, 5, 3}));
        System.out.println(trap1(new int[]{4, 5, 0, 3}));
        System.out.println(trap1(new int[]{10, 0, 3}));

    }

}
