package com.wsd.algorithm.leetcode;

/**
 * A96_UniqueBinarySearchTrees
 * Created by sdwang on 2020/2/20 18:12.
 */
public class A96_UniqueBinarySearchTrees {

    public static int numTrees(int n) {
        if(n==0||n==1)
            return 1;

        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }

}
