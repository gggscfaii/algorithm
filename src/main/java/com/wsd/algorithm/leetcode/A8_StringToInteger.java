package com.wsd.algorithm.leetcode;

/**
 * A8_StringToInteger
 * Created by sdwang on 2019/9/11 9:41.
 */
public class A8_StringToInteger {
    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("   42"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("-+1"));
        System.out.println(myAtoi("+-1"));
    }

    public static int myAtoi(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        int index = 0;
        while (index < str.length() && (str.charAt(index) == ' ' || str.charAt(index) == '\t')) index++;

        int sign = 1;
        if (index < str.length() && (str.charAt(index) == '-' || str.charAt(index) == '+')) {
            sign = str.charAt(index) == '-' ? -1 : 1;
            index++;
        }

        int num = 0;
        char c;
        while (index < str.length()) {
            c = str.charAt(index++);
            if (c < '0' || c > '9') {
                break;
            }

            int pop = c - '0';
            if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && pop > 7)) {
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            num *= 10;
            num += pop;
        }

        return sign * num;
    }

}
