package com.wsd.algorithm.test1;

public class ddtest {

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * 示例 1：
     * 输入: "babad" 输出: "bab" 注意: "aba" 也是一个有效答案。 示例 2：
     * 输入: "cbbd" 输出: "bb"
     */


    public static Boolean isEqualsStr(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    static String findMaxSubStr(String s) {
        int maxLength = -1;
        String resultStr = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                int length = j - i + 1;
                String subStr = s.substring(i, j + 1);
                if (isEqualsStr(subStr) && length > maxLength) {
                    maxLength = length;
                    resultStr = subStr;
                }
            }
        }
        return resultStr;
    }

    public static void main(String[] args) {
        System.out.println(findMaxSubStr("babad"));
        System.out.println(findMaxSubStr("cbbd"));

        System.out.println(findMaxSubStr("babadab"));
        System.out.println("---" + findMaxSubStr("a"));

    }
}
