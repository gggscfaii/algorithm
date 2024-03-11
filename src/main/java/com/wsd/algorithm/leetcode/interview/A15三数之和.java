package com.wsd.algorithm.leetcode.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class A15三数之和 {

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> resultList = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0
                            && (k == j + 1 || nums[k] != nums[k - 1])) {
                        List<Integer> sum = new ArrayList<>();
                        sum.add(nums[i]);
                        sum.add(nums[j]);
                        sum.add(nums[k]);
                        resultList.add(sum);
                    }
                }
            }
        }

        return resultList;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{-2, 0, 1, 1, 2};
        System.out.println(threeSum(nums));
    }
}
