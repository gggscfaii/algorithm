package com.wsd.algorithm.leetcode;

/**
 * A29_DivideTwoIntegers
 * Created by sdwang on 2020/1/20 19:33.
 */
public class A29_DivideTwoIntegers {

    public static int divide(int dividend, int divisor) {

        long m = dividend;
        long n = divisor;
        m = Math.abs(m);
        n = Math.abs(n);
        int sign = dividend < 0 ^ divisor < 0 ? -1 : 1;

        long t, p, res = 0;

        while (m >= n) {
            t = n;
            p = 1;
            while (m > t << 1) {
                p <<= 1;
                t <<= 1;
            }
            m -= t;
            res += p;
        }

        if (res > Integer.MAX_VALUE & sign > 0) {
            return Integer.MAX_VALUE;
        }
        return (int) (sign == 1 ? res : -res);
    }

    public static void main(String[] args) {
        System.out.println(divide(10, 3));
        System.out.println("0/2=" + divide(0, 2));
        System.out.println("10/2=" + divide(10, 2));
        System.out.println("10/3=" + divide(10, 3));
        System.out.println("10/5=" + divide(10, 5));
        System.out.println("10/7=" + divide(10, 7));
        System.out.println("10/10=" + divide(10, 10));
        System.out.println("10/11=" + divide(10, 11));
        System.out.println("-1/1=" + divide(1, -1));
        System.out.println("1/-1=" + divide(1, -1));
        System.out.println("-1/-1=" + divide(-1, -1));
        System.out.println("2147483647/1=" + divide(2147483647, 1));
        System.out.println("-2147483647/1=" + divide(-2147483647, 1));
        System.out.println("2147483647/-1=" + divide(2147483647, -1));
        System.out.println("-2147483647/-1=" + divide(-2147483647, -1));
        System.out.println("2147483647/2=" + divide(2147483647, 2));
        System.out.println("2147483647/10=" + divide(2147483647, 10));
        System.out.println("-2147483648/1=" + divide(-2147483648, 1));
        System.out.println("-2147483648/-1=" + divide(-2147483648, -1));

    }
}
