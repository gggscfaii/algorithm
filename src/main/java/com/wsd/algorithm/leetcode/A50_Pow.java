package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/1/30.
 */
public class A50_Pow {

    public static double myPow(double x, int n) {
        if (n == 0) return 1D;
        long N = n; // use long to avoid overflow.
        return solve(n < 0 ? (1 / x) : x, N < 0 ? (N * -1) : N);
    }

    public static double solve(double x, long n) {
        if (n == 1) return x;
        double val = solve(x, n / 2);
        return val * val * ((n % 2) == 0 ? 1 : x);
    }

    public static void main(String[] args) {
        System.out.println(myPow(10, 3));
        System.out.println(myPow(2, -2));
    }

}
