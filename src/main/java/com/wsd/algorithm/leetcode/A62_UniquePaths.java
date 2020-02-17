package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/2/12.
 */
public class A62_UniquePaths {

    public static int uniquePaths(int m, int n) {
        int dp[] = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    public static int uniquePaths(int x, int y, int m, int n) {
        if (m == x && n == y) {
            return 1;
        }

        int sum = 0;
        if (x < m) {
            sum += uniquePaths(x + 1, y, m, n);
        }

        if (y < n) {
            sum += uniquePaths(x, y + 1, m, n);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(1, 3));
    }

}
