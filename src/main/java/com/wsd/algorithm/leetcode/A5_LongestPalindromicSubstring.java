package com.wsd.algorithm.leetcode;

/**
 * A5_LongestPalindromicSubstring
 * 1.以某个点分别展开，判断是否为回文
 * 2.manacher算法需要理解
 * Created by sdwang on 2019/9/6 19:21.
 */
public class A5_LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("bab"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("bb"));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        int len;
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            len = expandAroundCenter(s, i, i);
            len = Math.max(len, expandAroundCenter(s, i, i + 1));

            if (len > (end - start)) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

}
