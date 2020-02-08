package com.wsd.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sdwang on 2020/1/24.
 */
public class A39_CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return dfs(candidates, 0, target);
    }

    private static List<List<Integer>> dfs(int[] candidates, int k, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        if (candidates.length <= 0) {
            return combinations;
        }

        for (int i = k; i < candidates.length; i++) {
            int candidate = candidates[i];
            int remainTarget = target - candidate;
            if (remainTarget < 0) {
                continue;
            }

            if (remainTarget == 0) {
                List<Integer> targets = new ArrayList<>();
                targets.add(candidate);
                combinations.add(targets);
                continue;
            }

            List<List<Integer>> subCombinations = dfs(candidates, i, remainTarget);
            if (subCombinations != null && subCombinations.size() > 0) {
                for (List<Integer> subCombination : subCombinations) {
                    List<Integer> targets = new ArrayList<>();
                    targets.add(candidate);
                    targets.addAll(subCombination);
                    combinations.add(targets);
                }
            }
        }

        return combinations;
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(combinationSum(new int[]{2, 3, 5}, 8));
    }
}
