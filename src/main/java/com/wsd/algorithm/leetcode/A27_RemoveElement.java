package com.wsd.algorithm.leetcode;

/**
 * A27_RemoveElement
 * Created by sdwang on 2020/1/20 18:41.
 */
public class A27_RemoveElement {

    public static int removeElement(int[] nums, int val) {
        if (nums.length <= 0) {
            return 0;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == val) {
                continue;
            }

            nums[i++] = nums[j];
        }
        return i;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len = removeElement(nums, 1);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + ",");
        }
    }
}
