package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/2/14.
 */
public class A75_SortColors {

    public static void sortColors(int[] nums) {

        int red = 0, blue = nums.length - 1;
        for (int i = 0; i <= blue; i++) {
            if (nums[i] == 0) {
                swap(nums, red++, i);
            }

            if (nums[i] == 2) {
                swap(nums, blue--, i--);
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int nums[] = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(nums);
        ArrayUtil.print(nums);
    }
}
