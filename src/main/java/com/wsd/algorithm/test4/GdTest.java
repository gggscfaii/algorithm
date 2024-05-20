package com.wsd.algorithm.test4;

public class GdTest {

    public static String findCommonStr(String s1, String s2) {

        int n = s2.length();
        String targetStr = "";
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                String s = s2.substring(i, j);
                if (s1.contains(s) && s.length() > targetStr.length()) {
                    targetStr = s;
                }
            }
        }
        return targetStr;
    }

    public static void main(String[] args) {
        System.out.println(findCommonStr("abc123", "abc123"));
    }
}
