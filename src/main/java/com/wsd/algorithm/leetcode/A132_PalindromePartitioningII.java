package com.wsd.algorithm.leetcode;

/**
 * A132_PalindromePartitioningII
 * Created by sdwang on 2020/3/16 14:29.
 */
public class A132_PalindromePartitioningII {

    public static int minCut(String s) {
        if (s.length() <= 0) return 0;
        int m = s.length();
        boolean[][] palindrome = new boolean[m][m];
        int[] dp = new int[m];
        for (int i = 0; i < m; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 1 || palindrome[j + 1][i - 1])) {
                    palindrome[j][i] = true;
                    if (j > 0) {
                        dp[i] = Math.min(dp[i], 1 + dp[j - 1]);
                    } else {
                        dp[i] = 0;
                    }
                }
            }
        }
        return dp[m - 1];
    }


    public static int minCut1(String s) {
        int n = s.length();
        boolean[][] judge = new boolean[n][n];
        int[] dp = new int[n]; // dp[i]表示s中第i个字符到第（n-1）个字符所构成的子串的最小分割次数
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || judge[i + 1][j - 1])) {
                    judge[i][j] = true;
                    if (j + 1 < n) {
                        dp[i] = Math.min(dp[i], 1 + dp[j + 1]);
                    } else {
                        dp[i] = 0;
                    }
                }
            }
        }
        return dp[0];
    }


    class Solution {
        public int minCut(String s) {
            int n = s.length();
            char[] chars = s.toCharArray();
            int[] minCuts = new int[n + 1];
            for (int i = 0; i < n + 1; i++) {
                minCuts[i] = i - 1;
            }
            //i表示双数中心的左中心点,表示单数中心的中心点
            for (int i = 0; i < n; i++) {
                f(chars, i, i, minCuts);
                f(chars, i, i + 1, minCuts);
            }
            return minCuts[n];
        }

        private void f(char[] chars, int left, int right, int[] minCuts) {
            while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
                minCuts[right + 1] = Math.min(minCuts[right + 1], minCuts[left] + 1);
                left--;
                right++;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(minCut("aab"));
        System.out.println(minCut1("aab"));
    }

}
