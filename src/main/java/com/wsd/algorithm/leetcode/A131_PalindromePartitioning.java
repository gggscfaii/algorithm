package com.wsd.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * A131_PalindromePartitioning
 * Created by sdwang on 2020/3/16 13:42.
 *
 * 可以加入dp
 */
public class A131_PalindromePartitioning {

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }

        for (int i = 1; i <= s.length(); i++) {
            String subString = s.substring(0, i);
            int left = 0, right = subString.length() - 1;
            while (left < right && subString.charAt(left) == subString.charAt(right)) {
                left++;
                right--;
            }
            if (left < right) {
                continue;
            }

            List<List<String>> subPartitions = partition(s.substring(i));
            if (subPartitions.size() <= 0) {
                List<String> r = new ArrayList<>();
                r.add(subString);
                result.add(r);
            } else {
                for (List<String> subPartition : subPartitions) {
                    List<String> r = new ArrayList<>();
                    r.add(subString);
                    r.addAll(subPartition);
                    result.add(r);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(partition("aab"));
        System.out.println(partition("bb"));
        System.out.println(partition("efe"));
        System.out.println(partition("abcdedcba"));
    }


    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<>();
            int m = s.length();
            boolean[][] dp = new boolean[m][m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j <= i; j++) {
                    if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1]))
                        dp[j][i] = true;
                }
            }
            dfs(res, new ArrayList<>(), 0, s, dp);
            return res;
        }

        public void dfs(List<List<String>> res, List<String> tmp, int start, String s, boolean[][] dp) {
            if (start >= s.length()) {
                res.add(new ArrayList<String>(tmp));
                return;
            }

            for (int i = start; i < s.length(); i++) {
                if (dp[start][i]) {
                    String sb = s.substring(start, i + 1);
                    tmp.add(sb);
                    dfs(res, tmp, i + 1, s, dp);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }
}
