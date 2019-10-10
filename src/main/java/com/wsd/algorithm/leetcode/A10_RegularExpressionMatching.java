package com.wsd.algorithm.leetcode;

/**
 * A10_RegularExpressionMatching
 * Created by sdwang on 2019/9/11 18:45.
 */
public class A10_RegularExpressionMatching {

    public static boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        boolean firstmatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return firstmatch && isMatch(s.substring(1), p)
                    || isMatch(s, p.substring(2));
        } else {
            return firstmatch && isMatch(s.substring(1), p.substring(1));
        }

    }

    public static void main(String[] args) {
        System.out.println(isMatch("aaaaab", ".*"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("mississippi", "mis*is*ip*."));

    }

}
