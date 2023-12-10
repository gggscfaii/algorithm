package com.wsd.algorithm.leetcode.interview;

public class A80删除有序数组中的重复项II {

    public static int removeDuplicates(int[] nums) {

        int i = 0;
        for (int num : nums) {
            if (i < 2 || num > nums[i - 2]) {
                nums[i] = num;
                i++;
            }
        }
        return i;
    }

}
