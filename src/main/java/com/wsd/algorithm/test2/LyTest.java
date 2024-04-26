package com.wsd.algorithm.test2;

import com.google.common.util.concurrent.RateLimiter;

import java.util.ArrayList;
import java.util.List;

public class LyTest {

    public static void findData(int[] data, int k, int m, int arrIndex, int index, List<List<Integer>> result, List<Integer> temp) {
        if (index == k && temp.stream().mapToInt(Integer::intValue).sum() == m) {
            result.add(new ArrayList<>(temp));
        }

        if (index >= k) {
            return;
        }

        for (int i = arrIndex; i < data.length; i++) {
            List<Integer> temp1 = new ArrayList<>(temp);
            temp1.add(data[i]);
            findData(data, k, m, i + 1, index + 1, result, temp1);
        }
    }

    public static List<List<Integer>> findData(int[] data, int k, int m) {
        List<List<Integer>> result = new ArrayList<>();
        findData(data, k, m, 0, 0, result, new ArrayList<>());
        return result;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(findData(data, 2, 7));
    }
}
