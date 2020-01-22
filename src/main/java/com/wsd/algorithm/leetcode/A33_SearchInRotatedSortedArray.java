package com.wsd.algorithm.leetcode;

/**
 * A33_SearchInRotatedSortedArray
 * Created by sdwang on 2020/1/21 19:18.
 */
public class A33_SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {
        if (nums.length <= 0) {
            return -1;
        }

        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (nums[middle] == target) {
                return middle;
            }

            if (nums[low] < nums[middle] && target >= nums[low] && target < nums[middle]) {
                high = middle - 1;
                continue;
            }

            if (nums[middle] < nums[high] && target > nums[middle] && target <= nums[high]) {
                low = middle + 1;
                continue;
            }

            if (nums[low] > nums[middle]) {
                high = middle - 1;
                continue;
            }

            if (nums[middle] > nums[high]) {
                low = middle + 1;
                continue;
            }

            return -1;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(search(new int[]{1}, 1));
        System.out.println(search(new int[]{1, 3}, 2));
        System.out.println(search(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8));
        System.out.println(search(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 9));

    }

}
