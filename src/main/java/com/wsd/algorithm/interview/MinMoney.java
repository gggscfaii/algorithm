package com.wsd.algorithm.interview;

import java.util.Arrays;

/**
 * MinMoney
 *
 * @author wangshudong
 * @date 2021/6/3
 */
public class MinMoney {

    public static int minMoney(int[] arr, int aim) {

        // write code here
        int[] dp = new int[aim + 1];
        Arrays.fill(dp, aim + 1);
        dp[0] = 0;
        for (int i = 1; i <= aim; i++) {
            //每一块钱
            for (int j = 0; j < arr.length; j++) {
                if (i - arr[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
                }
            }
        }
        return dp[aim] > aim ? -1 : dp[aim];

    }

    public static void main(String[] args) {
        System.out.println(minMoney(new int[]{5, 2, 3}, 20));
        System.out.println(minMoney(new int[]{5, 2, 3}, 0));

    }
}
