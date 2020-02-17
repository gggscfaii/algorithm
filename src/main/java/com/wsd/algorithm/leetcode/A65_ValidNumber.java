package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/2/12.
 */
public class A65_ValidNumber {
    public static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean isSpace(char c) {
        return (c == ' ' || c == '\t' || c == '\n' || c == '\r' || c == '\f');
    }

    public static boolean isNumber(String ss) {
        if(ss==null || ss.isEmpty()) return false;

        boolean num = false, numAfterE = true, dot = false, exp = false, sign = false;
        char[] s = ss.toCharArray();
        int n = s.length;
        for (int i = 0; i < n; ++i) {
            if (s[i] == ' ') {
                if (i < n - 1 && s[i + 1] != ' ' && (num || dot || sign)) return false;
            } else if (s[i] == '+' || s[i] == '-') {
                if (i > 0 && s[i - 1] != 'e' && s[i - 1] != ' ') return false;
                sign = true;
            } else if (s[i] >= '0' && s[i] <= '9') {
                num = true;
                numAfterE = true;
            } else if (s[i] == '.') {
                if (dot || exp) return false;
                dot = true;
            } else if (s[i] == 'e') {
                if (exp || !num) return false;
                exp = true;
                numAfterE = false;
            } else return false;
        }
        return num && numAfterE;
    }

    public static void main(String[] args) {
        System.out.println(isNumber(" -90e3   "));
        System.out.println(isNumber(" 99e2.5 "));

    }

}
