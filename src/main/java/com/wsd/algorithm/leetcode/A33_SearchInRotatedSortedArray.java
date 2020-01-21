package com.wsd.algorithm.leetcode;

/**
 * A33_SearchInRotatedSortedArray
 * Created by sdwang on 2020/1/21 19:18.
 */
public class A33_SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length;

        while (low < high) {
            int middle = low + (high - low) / 2;
            if (nums[middle] == target) {
                return middle;
            }

            if (nums[low])
        }
    }

}
