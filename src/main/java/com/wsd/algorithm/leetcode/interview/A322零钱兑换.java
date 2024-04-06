package com.wsd.algorithm.leetcode.interview;

public class A322零钱兑换 {

    public int coinChange(int[] coins, int amount) {

        if (amount == 0) {
            return 0;
        }
        int dp[] = new int[amount + 1];

        for (int i = 1; i < amount + 1; i++) {

            int minCount = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i == coins[j]) {
                    minCount = 1;
                    break;
                }

                if (i > coins[j] && i % coins[j] == 0) {
                    minCount = Math.min(minCount, i / coins[j]);
                }

                if (i > coins[j] && dp[i - coins[j]] > 0 && dp[coins[j]] > 0) {
                    minCount = Math.min(minCount, dp[i - coins[j]] + dp[coins[j]]);
                }
            }

            dp[i] = minCount == Integer.MAX_VALUE ? 0 : minCount;
        }
        return dp[amount] > 0 ? dp[amount] : -1;
    }

    public static void main(String[] args) {
        A322零钱兑换 a = new A322零钱兑换();
        System.out.println(a.coinChange(new int[]{1, 2, 5}, 11));
    }
}
