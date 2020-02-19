package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/2/19.
 */
public class A91_DecodeWays {

    public static int numDecodings(String s) {

        int length = s.length();
        if (length <= 0) return 0;

        if (s.charAt(0) == '0') return 0;
        int dp[] = new int[length];
        dp[0] = 1;
        for (int i = 1; i < length; i++) {
            if(s.charAt(i) !='0'){
                dp[i] += dp[i-1];
            }
            int str = Integer.parseInt(s.substring(i-1, i+1));
            if(str >=10 && str <=26) {
                f[i] += i>1?f[i-2]:1;
            }
        }
        return dp[length - 1];
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
