package com.wsd.algorithm.leetcode.interview;

public class A14最长公共前缀 {

    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = "";
        for (int curIndex = 0; curIndex < strs[0].length(); curIndex++) {
            char curChar = strs[0].charAt(curIndex);
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() - 1 < curIndex) {
                    return prefix;
                }

                if (strs[i].charAt(curIndex) != curChar) {
                    return prefix;
                }
            }
            prefix += curChar;
        }
        return prefix;
    }


    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));

    }

}
