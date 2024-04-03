package com.wsd.algorithm.test;

import java.util.ArrayList;
import java.util.List;

public class CombineNumTest {

    /**
     * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。1 <= n <= 20，1 <= k <= n。
     * * 你可以按 任何顺序 返回答案。
     * * 示例 1：
     * * 输入：n = 4, k = 2
     * * 输出：
     * * [
     * *   [2,4],
     * *   [3,4],
     * *   [2,3],
     * *   [1,2],
     * *   [1,3],
     * *   [1,4],
     * * ]
     * * 示例 2：
     * * 输入：n = 1, k = 1
     * * 输出：[[1]]
     */

    public static void combineNum(List<List<Integer>> res, List<Integer> combine, int n, int k, int start) {

        if (combine.size() == k) {
            res.add(combine);
            return;
        }

        for (int i = start; i <= n; i++) {
            List<Integer> combines = new ArrayList<>(combine);
            combines.add(i);
            combineNum(res, combines, n, k, i + 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        combineNum(res, new ArrayList<>(), 4, 2, 1);
        System.out.println(res);

        res = new ArrayList<>();
        combineNum(res, new ArrayList<>(), 4, 3, 1);
        System.out.println(res);

    }

}
