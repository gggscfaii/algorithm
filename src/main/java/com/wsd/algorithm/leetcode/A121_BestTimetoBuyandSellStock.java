package com.wsd.algorithm.leetcode;

/**
 * A121_BestTimetoBuyandSellStock
 * Created by sdwang on 2020/2/24 16:29.
 */
public class A121_BestTimetoBuyandSellStock {

    public static int maxProfit(int[] prices) {

        if (prices.length <= 1) {
            return 0;
        }

        int best = 0;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > buy) {
                best = Math.max(best, prices[i] - buy);
            } else {
                buy = prices[i];
            }
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
