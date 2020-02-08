package com.wsd.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sdwang on 2020/1/30.
 */
public class A46_Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, 0, result);
        return result;
    }

    public static void permute(int[] nums, int pos, List<List<Integer>> result) {
        if (pos == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            result.add(list);
        } else {
            for (int i = pos; i < nums.length; i++) {
                int temp = nums[i];
                nums[i] = nums[pos];
                nums[pos] = temp;
                permute(nums, pos + 1, result);
                temp = nums[i];
                nums[i] = nums[pos];
                nums[pos] = temp;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3, 4}));
    }
}
