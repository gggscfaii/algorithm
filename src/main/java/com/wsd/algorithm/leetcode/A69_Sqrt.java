package com.wsd.algorithm.leetcode;

/**
 * 牛顿迭代法
 * Created by sdwang on 2020/2/13.
 */
public class A69_Sqrt {

    public static int mySqrt(int x) {

        long res = x;
        while (res * res > x) {
            res = (res + x / res) / 2;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }
}
