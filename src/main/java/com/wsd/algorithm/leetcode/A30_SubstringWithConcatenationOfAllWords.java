package com.wsd.algorithm.leetcode;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;

/**
 * A30_SubstringWithConcatenationOfAllWords
 * Created by sdwang on 2020/1/21 16:16.
 */
public class A30_SubstringWithConcatenationOfAllWords {

    public static List<Integer> findSubstring(String s, String[] words) {

        if (s == null || s.length() <= 0) {
            return null;
        }

        if (words == null || words.length <= 0) {
            return null;
        }

        HashMap<String, Integer> expected = new HashMap<>();
        for (String word : words) {
            if (expected.containsKey(word)) {
                expected.put(word, expected.get(word) + 1);
            } else {
                expected.put(word, 1);
            }
        }

        int wordLength = words[0].length(), slength = s.length(), left, count;
        List<Integer> result = Lists.newArrayList();

        for (int i = 0; i < wordLength; i++) {
            HashMap<String, Integer> actual = new HashMap<>();
            left = i;
            count = 0;
            for (int j = i; j <= slength - wordLength; j += wordLength) {
                String word = s.substring(j, j + wordLength);
                if (!expected.containsKey(word)) {
                    actual.clear();
                    left = j + wordLength;
                    count = 0;
                    continue;
                }

                count++;
                if (actual.containsKey(word)) {
                    actual.put(word, actual.get(word) + 1);
                } else {
                    actual.put(word, 1);
                }

                if (actual.get(word) > expected.get(word)) {
                    String tmp;
                    do {
                        tmp = s.substring(left, left + wordLength);
                        count--;
                        actual.put(tmp, actual.get(tmp) - 1);
                        left += wordLength;
                    } while (!tmp.equals(word));
                }

                if (count == words.length) {
                    result.add(left);
                    String tmp = s.substring(left, left + wordLength);
                    actual.put(tmp, actual.get(tmp) - 1);
                    left += wordLength;
                    count--;
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "barfoobarfoothefoobarman";
        System.out.println(findSubstring(s, new String[]{"foo", "bar", "foo"}));
        System.out.println(findSubstring("aaa", new String[]{"aa", "aa"}));
    }

}
