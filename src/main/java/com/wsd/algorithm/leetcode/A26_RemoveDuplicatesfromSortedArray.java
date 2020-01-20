package com.wsd.algorithm.leetcode;

/**
 * A26_RemoveDuplicatesfromSortedArray
 * Created by sdwang on 2020/1/20 18:20.
 */
public class A26_RemoveDuplicatesfromSortedArray {

    public static int removeDuplicates(int[] nums) {
//        int currentNumber, currentIndex, len;
//        currentNumber = nums[0];
//        currentIndex = 1;
//        len = 1;
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] != currentNumber) {
//                currentNumber = nums[i];
//                nums[currentIndex++] = nums[i];
//                len++;
//            }
//        }
//        return len;

        if (nums.length == 0) return 0;
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
        int nums[] = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len = removeDuplicates(nums);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + ",");
        }
    }

}
