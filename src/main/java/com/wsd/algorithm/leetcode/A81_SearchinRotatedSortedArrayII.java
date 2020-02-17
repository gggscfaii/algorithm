package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/2/15.
 */
public class A81_SearchinRotatedSortedArrayII {

    public static boolean search(int[] nums, int target) {
        if (nums.length <= 0) {
            return false;
        }

        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (nums[middle] == target) {
                return true;
            }

            if (nums[middle] < nums[high]) {
                if (nums[middle] < target && nums[high] >= target) {
                    low = middle + 1;
                } else {
                    high = middle - 1;
                }
            } else if (nums[middle] > nums[high]) {
                if (nums[middle] > target && nums[high] < target) {
                    high = middle - 1;
                } else {
                    low = middle + 1;
                }
            } else {
                high--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 1, 3, 1}, 3));
        System.out.println(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
        System.out.println(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
        System.out.println(search(new int[]{3}, 3));
        System.out.println(search(new int[]{3, 1}, 3));
        System.out.println(search(new int[]{1, 3}, 3));
        System.out.println(search(new int[]{3, 1}, 1));
        System.out.println(search(new int[]{3, 5, 1}, 3));
        System.out.println(search(new int[]{5, 1, 3}, 5));

    }

}
