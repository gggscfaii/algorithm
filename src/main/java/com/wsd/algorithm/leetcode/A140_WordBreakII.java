package com.wsd.algorithm.leetcode;

import java.util.List;

/**
 * A140_WordBreakII
 *
 * @author wangshudong
 * @date 2021/9/30
 */
public class A140_WordBreakII {

    public List<String> wordBreak(String s, List<String> wordDict) {
        // boolean[] dp = new boolean[s.length() + 1];
        // dp[0] = true;
        // for (int i = 1; i <= s.length(); i++) {
        //     String sub = s.substring(0, i);
        //     for (int j = 0; j < wordDict.size(); j++) {
        //         String w = wordDict.get(j);
        //         if (sub.endsWith(w)) {
        //             dp[i] = dp[i] | dp[i - w.length()];
        //         }
        //         if (dp[i]) break;
        //     }
        // }
        //
        // return dp[s.length()];

        return null;
    }

}
