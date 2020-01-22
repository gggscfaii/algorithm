package com.wsd.algorithm.leetcode;

import java.util.Arrays;

/**
 * A34_FindFirstandLastPositionofElementInSortedArray
 * Created by sdwang on 2020/1/22 11:13.
 */
public class A34_FindFirstandLastPositionofElementInSortedArray {

    public static int[] searchRange(int[] nums, int target) {

        int[] positions = new int[]{-1, -1};
        if (nums.length <= 0) {
            return positions;
        }

        int leftIndex = externalSearch(nums, target, true);

        if (leftIndex== nums.length || nums[leftIndex] != target) {
            return positions;
        }

        positions[0] = leftIndex;
        positions[1] = externalSearch(nums, target, false) - 1;
        return positions;
    }

    private static int externalSearch(int[] nums, int target, boolean left) {
        int low = 0, high = nums.length;
        while (low < high) {
            int middle = (high + low) / 2;
            if (nums[middle] > target || (left && target == nums[middle])) {
                high = middle;
            } else {
                low = middle + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{0, 1, 2, 4, 8, 10}, 2)));

    }
}
