package com.wsd.algorithm.leetcode;

import java.util.*;

/**
 * Created by sdwang on 2020/1/30.
 */
public class A49_GroupAnagrams {

    private static int[] A = new int[256];

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            Arrays.fill(A, 0);
            for (char c : str.toCharArray()) {
                A[c] += 1;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < A.length; i++) {
                for (int k = 0; k < A[i]; k++) {
                    sb.append((char) i);
                }
            }

            List<String> group = map.computeIfAbsent(sb.toString(), k -> new ArrayList<>());
            group.add(str);
        }

        List<List<String>> groups = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            groups.add(entry.getValue());
        }

        return groups;
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

}
