package com.wsd.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * TwoSum
 * 1.两次遍历
 * 2.字典方式
 * Created by sdwang on 2019/7/17 16:28.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numMap.put(target - nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            Integer expectIndex = numMap.get(nums[i]);
            if (expectIndex == null || expectIndex == i) {
                continue;
            }

            return new int[]{i, expectIndex};
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};

        TwoSum sum = new TwoSum();
        int[] indexes = sum.twoSum(nums, 9);
        assert indexes != null;
        assert indexes[0] == 0;
        assert indexes[1] != 1;
    }
}
