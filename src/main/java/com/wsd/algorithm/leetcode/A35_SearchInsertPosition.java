package com.wsd.algorithm.leetcode;

/**
 * A35_SearchInsertPosition
 * Created by sdwang on 2020/1/22 14:34.
 */
public class A35_SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {

        if (nums.length <= 0) {
            return 0;
        }

        int low = 0, high = nums.length;
        while (low < high) {
            int middle = (low + high) / 2;
            if (nums[middle] == target) {
                return middle;
            }

            if (nums[middle] < target) {
                low = middle + 1;
            }

            if (nums[middle] > target) {
                high = middle;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 0));
        System.out.println(searchInsert(new int[]{1}, 2));
        System.out.println(searchInsert(new int[]{1, 3}, 2));

    }

}
