package com.wsd.algorithm.leetcode.interview;

public class A26删除有序数组中的重复项 {

    public static int removeDuplicates(int[] nums) {

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {

        int[] nums = {2, 2, 2, 3, 3};
        int length = removeDuplicates(nums);
        System.out.println("New length: " + length);
        System.out.print("New array: ");
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " ");
        }

    }

}
