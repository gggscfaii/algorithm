package com.wsd.algorithm.leetcode;

/**
 * A10_RegularExpressionMatching
 * Created by sdwang on 2019/9/11 18:45.
 */
public class A10_RegularExpressionMatching {

    public static boolean isMatch(String s, String p) {
        if ((s == null || s.equals("")) && (p == null || p.equals(""))) {
            return true;
        }

        if ((s == null || s.equals("")) && p != null) {
            return true;
        }

        if (p == null || p.equals("")) {
            return true;
        }

        int i = 0, j = 0;
        boolean match = false;
        while (i < s.length() && j < p.length()) {
            if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
                match = true;
            }

            if (p.charAt(j) == '*' && match) {
                i++;
                continue;
            }

            if (match) {
                j++;
                i++;
            } else {
                j++;
                match = false;
            }
        }

        return i == s.length();
    }

    public static void main(String[] args) {
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("mississippi", "mis*is*p*."));

    }

}
