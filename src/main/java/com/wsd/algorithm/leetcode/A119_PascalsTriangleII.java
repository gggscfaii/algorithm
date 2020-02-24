package com.wsd.algorithm.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * A119_PascalsTriangleII
 * Created by sdwang on 2020/2/24 11:36.
 */
public class A119_PascalsTriangleII {

    public static List<Integer> getRow(int rowIndex) {

        Integer[] result = new Integer[rowIndex + 1];
        Arrays.fill(result, 0);
        result[0] = 1;
        for (int i = 0; i < rowIndex + 1; i++) {
            for (int j = i; j >= 1; j--) {
                result[j] += result[j - 1];
            }
        }
        return Arrays.asList(result);
    }

    public static void main(String[] args) {
        System.out.println(getRow(2));
        System.out.println(getRow(3));
        System.out.println(getRow(4));
    }

}
