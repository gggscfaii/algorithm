package com.wsd.algorithm.leetcode;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * A120_Triangle
 * Created by sdwang on 2020/2/24 14:25.
 */
public class A120_Triangle {

    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty()) return 0;

        int memo[][] = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        return minimumTotal(triangle, 0, 0, memo);
    }

    public static int minimumTotal(List<List<Integer>> triangle,
                                   int level, int pos,
                                   int memo[][]) {
        if (level >= triangle.size()) {
            return 0;
        }

        if (memo[level][pos] != 0) {
            return memo[level][pos];
        }

        int left = minimumTotal(triangle, level + 1, pos, memo);
        int right = minimumTotal(triangle, level + 1, pos + 1, memo);

        if (left < right) {
            memo[level][pos] = triangle.get(level).get(pos) + left;
        } else {
            memo[level][pos] = triangle.get(level).get(pos) + right;
        }
        return memo[level][pos];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Lists.newArrayList(2));
        triangle.add(Lists.newArrayList(3, 4));
        triangle.add(Lists.newArrayList(6, 5, 7));
        triangle.add(Lists.newArrayList(4, 1, 8, 3));
        System.out.println(minimumTotal(triangle));

        triangle = new ArrayList<>();
        triangle.add(Lists.newArrayList(-1));
        triangle.add(Lists.newArrayList(2, 3));
        triangle.add(Lists.newArrayList(1, -1, -3));
        System.out.println(minimumTotal(triangle));
    }

}
