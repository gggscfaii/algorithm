package com.wsd.algorithm.leetcode;

/**
 * A7_ReverseInteger
 * Created by sdwang on 2019/9/9 19:33.
 */
public class A7_ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-1234));
        System.out.println(reverse(120));
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        int p = 0;
        int pop;
        while (x != 0) {
            pop = x % 10;
            if (p > Integer.MAX_VALUE / 10 || (p == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (p < Integer.MIN_VALUE / 10 || (p == Integer.MIN_VALUE / 10 && pop < -8)) return 0;

            p = p * 10;
            p += pop;
            x = x / 10;
        }
        return p;
    }
}