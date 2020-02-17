package com.wsd.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sdwang on 2020/2/14.
 */
public class A77_Combinations {

    public static List<List<Integer>> combine(int n, int k) {

        int nums[] = new int[k];
        List<List<Integer>> combines = new ArrayList<>();
        combine(n, 0, 0, k, nums, combines);
        return combines;
    }

    public static void combine(int n, int start, int index, int k, int[] nums, List<List<Integer>> combines) {
        if (k == 0) {
            List<Integer> combine = new ArrayList<>();
            for (int num : nums) {
                combine.add(num);
            }
            combines.add(combine);
            return;
        }

        for (int i = start + 1; i <= n; i++) {
            nums[index] = i;
            combine(n, i, index + 1, k - 1, nums, combines);
        }
    }

    public static List<List<Integer>> combine1(int n, int k) {
        int[] subArr = new int[k];
        List<List<Integer>> result = new ArrayList<>();
        getNext(0, 0, n, k, subArr, result);
        return result;
    }

    private static void getNext(int i, int count, int n, int k, int[] subArr, List<List<Integer>> result) {
        if (k == 0) {
            List<Integer> subList = new ArrayList<>();
            for (int a : subArr) subList.add(a);
            result.add(subList);
        } else {
            for (int j = i + 1; j <= n; j++) {
                subArr[count] = j;
                getNext(j, count + 1, n, k - 1, subArr, result);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
        System.out.println(combine1(4, 2));

    }
}
