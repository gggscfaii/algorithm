package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/2/12.
 */
public class A64_MinimumPathSum {

    public static int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int dp[] = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[j] = (j > 0 ? dp[j - 1] : dp[j]) + grid[i][j];
                } else {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1, 2}, {1, 1}}));
    }
}
