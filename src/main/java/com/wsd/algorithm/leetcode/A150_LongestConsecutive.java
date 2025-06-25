package com.wsd.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

public class A150_LongestConsecutive {

    public static int longestConsecutive(int[] nums) {

        int len = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) > nums.length) {
                continue;
            }

            if (nums[i] == 0) {
                continue;
            }

            if (!set.contains(nums[i])) {
                len++;
            }
            set.add(nums[i]);
        }

        int[] newNum = new int[len * 2 + 1];
        newNum[len] = -1;
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) > len) {
                continue;
            }

            if (nums[i] < 0) {
                newNum[len + nums[i]] = nums[i];
            } else {
                newNum[len + nums[i]] = len + nums[i];
            }
        }

        int start = -1;
        int maxLen = 0;
        for (int i = 0; i < newNum.length; i++) {
            if (i == ((i < len) ? (len + newNum[i]) : newNum[i])) {
                if (start == -1) {
                    start = i;
                }
                maxLen = Math.max(maxLen, (i - start) + 1);
            } else {
                start = -1;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
//        System.out.println(longestConsecutive(new int[]{0, 0, -1}));
//        System.out.println(longestConsecutive(new int[]{1, 0, -1}));
//        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(longestConsecutive(new int[]{-8, -4, 9, 9, 4, 6, 1, -4, -1, 6, 8}));
    }

}
