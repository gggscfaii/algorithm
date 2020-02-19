package com.wsd.algorithm.leetcode;

/**
 * 动态规划算法
 * a,b交换法后续可以尝试
 * Created by sdwang on 2020/2/19.
 */
public class A91_DecodeWays {

    public static int numDecodings(String s) {

        int length = s.length();
        if (length <= 0) return 0;

        if (s.charAt(0) == '0') return 0;
        int dp[] = new int[length + 1];
        dp[0] = 1;
        for (int i = 1; i < length + 1; i++) {
            dp[i] = (s.charAt(i - 1) == '0') ? 0 : dp[i - 1];

            if (i > 1 && (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6'))) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[length];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("101"));
        System.out.println(numDecodings("12"));
        System.out.println(numDecodings("226"));
        System.out.println(numDecodings("27"));
        System.out.println(numDecodings("01"));
        System.out.println(numDecodings("10"));
        System.out.println(numDecodings("100"));
    }

}
