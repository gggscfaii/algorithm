package com.wsd.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * A89_GrayCode
 * Created by sdwang on 2020/2/18 18:48.
 */
public class A89_GrayCode {

    public static List<Integer> grayCode(int n) {
        List<Integer> codes = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, n); i++) {
            codes.add((i >> 1) ^ i);
        }
        return codes;
    }

    public static void main(String[] args) {
        System.out.println(grayCode(2));
    }
}
