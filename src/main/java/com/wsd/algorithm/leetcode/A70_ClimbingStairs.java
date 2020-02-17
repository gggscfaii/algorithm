package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/2/13.
 */
public class A70_ClimbingStairs {

    public static int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }

        int dp[] = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

}
