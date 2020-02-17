package com.wsd.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 康托展开运算
 * Created by sdwang on 2020/2/10.
 */
public class A60_PermutationSequence {

    public static String getPermutation(int n, int k) {

        // 存储阶乘
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            factorial[i] = sum;
        }
        // 如果k越界，返回null
        if (k > factorial[n])
            return null;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(i + 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int index = (k - 1) / factorial[n - i];
            sb.append(list.get(index));
            list.remove(index);
            k = k - index * factorial[n - i];
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(3, 2));
    }
}
