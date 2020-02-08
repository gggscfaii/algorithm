package com.wsd.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sdwang on 2020/1/30.
 */
public class A47_PermutationsII {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
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
                if (i > pos && nums[pos] == nums[i]) continue;
                int temp = nums[i];
                nums[i] = nums[pos];
                nums[pos] = temp;
                permute(Arrays.copyOf(nums, nums.length), pos + 1, result);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3, 4, 1}));
    }

}
