package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/1/26.
 */
public class A44_WildcardMatching {

    public static boolean isMatch(String s, String p) {
        int i = 0, j = 0, iStar = -1, jStar = -1;
        while (i < s.length()) {
            if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                ++j;
                ++i;
            } else if (j < p.length() && p.charAt(j) == '*') {
                jStar = j++;
                iStar = i;
            } else if (iStar != -1) {
                i = iStar + 1;
                j = jStar;
            } else {
                return false;
            }
        }

        while (j < p.length() && p.charAt(j) == '*') {
            ++j;
        }
        return j == p.length();
    }

    public static void main(String[] args) {
        System.out.println(isMatch("ss", "*"));
        System.out.println(isMatch("cb", "?b"));
        System.out.println(isMatch("cb", "?a"));
        System.out.println(isMatch("adceb", "*a*b"));
        System.out.println(isMatch("abefcdgiescdfimde", "ab*cd?i*de"));
        System.out.println(isMatch("", "*"));
    }

}
