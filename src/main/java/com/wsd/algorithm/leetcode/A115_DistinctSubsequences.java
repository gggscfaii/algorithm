package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/2/23.
 */
public class A115_DistinctSubsequences {
    public static int numDistinct(String s, String t) {

        int n = s.length(), m = t.length();
        int dp[][] = new int[m + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = i; j < n + 1; j++) {
                dp[i][j] = dp[i][j - 1] + (t.charAt(i - 1) == s.charAt(j - 1) ? dp[i - 1][j - 1] : 0);
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
        System.out.println(numDistinct("babgbag", "bag"));

    }
}
