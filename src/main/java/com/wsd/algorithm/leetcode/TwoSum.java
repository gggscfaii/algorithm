package com.wsd.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * TwoSum
 * 1.两次遍历(未给出)
 * 2.字典方式(1次循环)
 * 3.预排序，高低相加
 * Created by sdwang on 2019/7/17 16:28.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            Integer index = numMap.get(value);
            if (index != null) {
                return new int[]{index, i};
            }
            numMap.put(nums[i], i);
        }
        return null;
    }

    public int[] sortTwoSum(int[] nums, int target) {
        int low = 0, high = nums.length - 1, value;
        while (low < high) {
            value = nums[low] + nums[high];
            if (value > target) {
                high--;
            } else if (value < target) {
                low++;
            } else {
                return new int[]{low, high};
            }
        }
        return null;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};

        TwoSum sum = new TwoSum();
        int[] indexes = sum.twoSum(nums, 9);
        assert indexes != null;
        assert indexes[0] == 0;
        assert indexes[1] == 1;
        System.out.println(Arrays.toString(indexes));

        nums = new int[]{11, 3, 9, 15, 12};

        Arrays.sort(nums);
        indexes = sum.sortTwoSum(nums, 14);
        assert indexes != null;
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(indexes));
    }
}
