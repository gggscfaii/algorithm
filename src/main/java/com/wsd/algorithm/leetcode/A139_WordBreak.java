package com.wsd.algorithm.leetcode;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * A139_WordBreak
 *
 * @author wangshudong
 * @date 2021/9/30
 */
public class A139_WordBreak {

    public static boolean wordBreak(int start, String s, List<String> wordDict) {

        if (start == s.length()) {
            return true;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            String subS = s.substring(start, i);
            if (wordDict.contains(subS) && wordBreak(i, s, wordDict)) {
                return true;
            }
        }

        return false;
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(0, s, wordDict);
    }


    public static boolean wordBreak1(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            for (int j = 0; j < wordDict.size(); j++) {
                String w = wordDict.get(j);
                if (sub.endsWith(w)) {
                    dp[i] = dp[i] | dp[i - w.length()];
                }
                if (dp[i]) break;
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", Lists.newArrayList("leet", "code")));
        System.out.println(wordBreak("applepenapple", Lists.newArrayList("apple", "pen")));
        System.out.println(wordBreak("catsandog", Lists.newArrayList("cats", "dog", "sand", "and", "cat")));

        System.out.println(wordBreak1("leetcode", Lists.newArrayList("leet", "code")));
        System.out.println(wordBreak1("applepenapple", Lists.newArrayList("apple", "pen")));
        System.out.println(wordBreak1("catsandog", Lists.newArrayList("cats", "dog", "sand", "and", "cat")));

    }
}
