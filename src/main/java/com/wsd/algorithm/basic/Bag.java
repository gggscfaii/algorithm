package com.wsd.algorithm.basic;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Bag
 * Created by sdwang on 2020/1/17 18:20.
 */
public class Bag {

    public static void bag01(int w[], int v[], int bagWeight) {

        int maxValue[][] = new int[w.length][bagWeight + 1];

        for (int i = 1; i < w.length; i++) {
            for (int j = 1; j <= bagWeight; j++) {
                if (w[i] > j) {
                    maxValue[i][j] = maxValue[i - 1][j];
                } else {
                    maxValue[i][j] = Math.max(maxValue[i - 1][j], maxValue[i - 1][j - w[i]] + v[i]);
                }
            }
        }

        for (int i = 0; i < w.length; i++) {
            System.out.print(w[i] + "\t");
            System.out.print(v[i] + "\t");
            for (int j = 0; j <= bagWeight; j++) {
                System.out.print(maxValue[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int bagGreedyAlgorithm(int w[], int v[], int bagWeight, List<Integer> ps) {
        if (bagWeight <= 0) {
            return 0;
        }

        int maxValue = 0;
        List<Integer> ps1 = ps;
        for (int i = 1; i < w.length; i++) {
            if (ps == null) {
                ps1 = Lists.newArrayList();
            }

            if (ps1.contains(i)) {
                continue;
            }
            if (w[i] > bagWeight) continue;

            ps1.add(i);
            maxValue = Math.max(maxValue, bagGreedyAlgorithm(w, v, bagWeight - w[i], ps1) + v[i]);
        }
        return maxValue;
    }

    public static void main(String[] args) {

        bag01(new int[]{0, 2, 2, 6, 5, 4}, new int[]{0, 6, 3, 5, 4, 6}, 10);

        System.out.println(bagGreedyAlgorithm(new int[]{0, 2, 2, 6, 5, 4}, new int[]{0, 6, 3, 5, 4, 6}, 10, null));

    }


}
