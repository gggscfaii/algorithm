package com.wsd.algorithm.leetcode;

/**
 * A122_BestTimetoBuyandSellStockII
 * Created by sdwang on 2020/2/24 16:37.
 */
public class A122_BestTimetoBuyandSellStockII {

    public static int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}));
    }
}
