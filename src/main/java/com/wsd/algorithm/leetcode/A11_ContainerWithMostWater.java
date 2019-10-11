package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2019/10/11.
 */
public class A11_ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }

    private static int maxArea(int low, int high, int[] height) {
        int maxHeightIndex = -1;
        for (int i = low; i <= high; i++) {
            if (height[i] <= height[low] || height[i] <= height[high]) {
                continue;
            }

            if (maxHeightIndex == -1) {
                maxHeightIndex = i;
                continue;
            }

            if (height[maxHeightIndex] < height[i]) {
                maxHeightIndex = i;
            }
        }

        if (maxHeightIndex < 0) {
            return Math.min(height[low], height[high]) * (high - low);
        } else {
            return Math.max(maxArea(low, maxHeightIndex, height), maxArea(maxHeightIndex, high, height));
        }
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
