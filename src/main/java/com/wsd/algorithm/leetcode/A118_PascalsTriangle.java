package com.wsd.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * A118_PascalsTriangle
 * Created by sdwang on 2020/2/24 11:24.
 */
public class A118_PascalsTriangle {

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            result.add(new ArrayList<>());
            for (int j = 0; j <= i; j++) {
                if (i > 1 && j > 0 && j < i) {
                    result.get(i).add(result.get(i - 1).get(j) + result.get(i - 1).get(j - 1));
                } else {
                    result.get(i).add(1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }

}
