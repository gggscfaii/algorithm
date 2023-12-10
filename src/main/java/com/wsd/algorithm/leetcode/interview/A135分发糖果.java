package com.wsd.algorithm.leetcode.interview;

public class A135分发糖果 {

    public static int candy(int[] ratings) {

        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] += left[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] += right[i + 1] + 1;
            }
        }

        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            sum += Math.max(left[i], right[i]) + 1;
        }

        return sum;

    }

    public static void main(String[] args) {
        System.out.println(candy(new int[]{1, 0, 2}));
        System.out.println(candy(new int[]{1, 2, 2}));
        System.out.println(candy(new int[]{1, 3, 2, 2, 1}));
        System.out.println(candy(new int[]{1, 2, 87, 87, 87, 2, 1}));
    }
}
