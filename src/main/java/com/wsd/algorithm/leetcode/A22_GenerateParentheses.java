package com.wsd.algorithm.leetcode;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * A22_GenerateParentheses
 * Created by sdwang on 2020/1/20 10:00.
 */
public class A22_GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        List<String> ans = Lists.newArrayList();
        backTrack(ans, "", 0, 0, n);
        return ans;
    }

    public static void backTrack(List<String> ans, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max) {
            backTrack(ans, cur + "(", open + 1, close, max);
        }

        if (close < open) {
            backTrack(ans, cur + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        List<String> ans = generateParenthesis(3);
        for (String an : ans) {
            System.out.println(an);
        }

    }
}
