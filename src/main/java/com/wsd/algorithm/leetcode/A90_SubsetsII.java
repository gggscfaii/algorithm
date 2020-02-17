package com.wsd.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sdwang on 2020/2/18.
 */
public class A90_SubsetsII {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        if (nums.length <= 0) {
            return result;
        }

        Arrays.sort(nums);
        int preCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = 0;
            if (i > 0 && nums[i] == nums[i - 1]) {
                j = preCount;
            } else {
                preCount = 0;
            }

            for (int resLen = result.size(); j < resLen; j++) {
                ArrayList<Integer> newList = new ArrayList<>(result.get(j));
                newList.add(nums[i]);
                result.add(newList);
                preCount++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1, 2, 3, 3, 4}));
        System.out.println(subsetsWithDup(new int[]{1, 1, 1}));
        System.out.println(subsetsWithDup(new int[]{5, 5, 5, 5, 5}));

    }
}

