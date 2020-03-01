package com.wsd.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * A128_LongestConsecutiveSequence
 * Created by sdwang on 2020/2/25 14:50.
 */
public class A128_LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {

        Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            s.add(num);
        }

        int res = 0;
        for (int val : nums) {
            if (!s.contains(val)) continue;
            int pre = --val, next = ++val;
            while (s.contains(pre)) s.remove(pre--);
            while (s.contains(next)) s.remove(next++);
            res = Math.max(res, next - pre - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{
                100, 4, 200, 1, 3, 2
        }));

        int val = 10;
        int pre = --val, next = ++val;
        System.out.println(pre);
        System.out.println(next);
    }

}
