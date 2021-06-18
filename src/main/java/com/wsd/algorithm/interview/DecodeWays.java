package com.wsd.algorithm.interview;

import org.apache.commons.lang.StringUtils;

/**
 * DecodeWays
 *
 * @author wangshudong
 * @date 2021/6/4
 */
public class DecodeWays {

    /***
     * 给定一个字符串str，str全部由数字字符组成，如果str中的某一个或者相邻两个字符组成的子串值在1~26之间，
     * 则这个子串可以转换为一个字母。规定‘1’转换为“A”，“2”转换为“B”......"26"转化为“Z“。
     * 请求出str有多少种不同的转换结果，由于答案可能会比较大，所以请输出对10^{9}+7109
     *  +7取模后的答案。
     * @param str
     * @return
     */

    public static int decodeWays(String str) {

        if (StringUtils.isEmpty(str)) {
            return 0;
        }

        if (str.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[str.length()];
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            int value = str.charAt(0) - '0';
            if (value >= 1 && value <= 9) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i - 1];
            }

            value = (str.charAt(i - 1) - '0') * 10 + (str.charAt(i) - '0');
            if (i > 1 && 10 <= value && value <= 26) {
                dp[i] = dp[i] + 1;
            }
        }

        return dp[dp.length - 1];
        // return dp[dp.length - 1];
    }

    public static int decodeWays1(String str) {
        if (str.length() == 0 || str.charAt(0) == '0') {
            return 0;
        }
        int length = str.length();
        int fn = 1;
        int fn1 = 1;
        int fn2 = 1;
        for (int i = 1; i < length; i++) {
            fn2 = fn1;
            fn1 = fn;
            fn = 0;
            if (str.charAt(i) != '0') {
                fn = fn + fn1;
            }
            int c = (str.charAt(i - 1) - '0') * 10 + (str.charAt(i) - '0');
            if (10 <= c && c <= 26) {
                fn = fn + fn2;
            }
            if (fn == 0) {
                break;
            }
            fn = fn % 1000000007;
        }
        return fn;
    }

    public static void main(String[] args) {
        System.out.println(decodeWays("1111"));
    }
}
