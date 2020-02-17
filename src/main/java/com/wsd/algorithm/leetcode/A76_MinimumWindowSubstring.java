package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/2/14.
 */
public class A76_MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        int[] chars = new int[128];
        for (int i = 0; i < t.length(); i++) chars[t.charAt(i)]++;

        int cnt = 0;
        int left = 0, min = Integer.MAX_VALUE, minLeft = -1;
        for (int i = 0; i < s.length(); i++) {
            if (--chars[s.charAt(i)] >= 0) cnt++;

            while (cnt == t.length()) {
                if (min > i - left + 1) {
                    min = i - left + 1;
                    minLeft = left;
                }

                if (++chars[s.charAt(left)] > 0) --cnt;
                ++left;
            }
        }

        if (minLeft == -1) return "";
        return s.substring(minLeft, minLeft + min);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("AACNBA", "CBA"));
    }

}
