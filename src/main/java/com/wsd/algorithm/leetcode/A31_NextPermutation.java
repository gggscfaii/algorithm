package com.wsd.algorithm.leetcode;

/**
 * A31_NextPermutation
 * Created by sdwang on 2020/1/21 17:47.
 */
public class A31_NextPermutation {

    public static void nextPermutation(int[] nums) {
        if (nums.length <= 1) return;

        for (int i = nums.length; i > 0; i++) {
            if (nums[i] > nums[i - 1]) {
                int j = nums.length - 1;
                while (nums[j] <= nums[i - 1]) {
                    j--;
                }

                swap(nums, j, i - 1);
                int tmp = nums[j];
                nums[j] = nums[i - 1];
                nums[i - 1] = tmp;

                reverse(nums, i, nums.length-1);
                return;
            }

            if (i == 1) {
                //sort works as well
                //sort(num.begin(), num.end());
                reverse(nums, 0, nums.length-1);
                return;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {

    }
}
