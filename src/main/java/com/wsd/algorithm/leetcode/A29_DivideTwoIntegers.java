package com.wsd.algorithm.leetcode;

/**
 * A29_DivideTwoIntegers
 * Created by sdwang on 2020/1/20 19:33.
 */
public class A29_DivideTwoIntegers {

    public static int divide(int dividend, int divisor) {
        boolean plus = dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0;
        int len = 0;
        while () {
            if (plus) {
                dividend += divisor;
            } else {
                dividend -= divisor;
            }
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(divide(10, 3));
    }
}
