package com.wsd.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * A3_LongestSubstringWithoutRepeatingCharacters
 * Created by sdwang on 2019/7/17 18:14.
 */
public class A3_LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {

        int ans, start;
        ans = start = 0;

        Map<Character, Integer> map = new HashMap<>(); // current index of character
        for (int i = 0, slen = s.length(); i < slen; i++) {
            if (map.containsKey(s.charAt(i))) {
                start = Math.max(map.get(s.charAt(i)), start);
            }
            ans = Math.max(ans, i - start + 1);
            map.put(s.charAt(i), i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcadbcbb"));
        System.out.println(lengthOfLongestSubstring("au"));
        System.out.println(lengthOfLongestSubstring("b"));
        System.out.println(lengthOfLongestSubstring("bb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
