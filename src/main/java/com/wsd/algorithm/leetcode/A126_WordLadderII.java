package com.wsd.algorithm.leetcode;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * A126_WordLadderII
 * Created by sdwang on 2020/2/25 11:34.
 */
public class A126_WordLadderII {


    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> result = new ArrayList<>();
        List<Integer> resultIndex = new ArrayList<>();

        int maxTransferCount = 0;
        for (int i = 0; i < beginWord.length(); i++) {
            if (beginWord.charAt(i) != endWord.charAt(i)) maxTransferCount++;
        }

        findLadder(beginWord, endWord, wordList, result, resultIndex, maxTransferCount, 0);

        for (List<String> r : result) {
            r.add(0, beginWord);
        }
        return result;
    }

    public static void findLadder(String beginWord, String endWord, List<String> wordList,
                                  List<List<String>> result, List<Integer> resultIndex,
                                  int maxTransferCount, int level) {

        if (beginWord.equalsIgnoreCase(endWord)) {
            if (!result.isEmpty()) {
                if (result.get(0).size() < resultIndex.size()) {
                    return;
                }

                if (result.get(0).size() > resultIndex.size()) {
                    result.clear();
                }
            }

            List<String> r = new ArrayList<>();
            for (Integer index : resultIndex) {
                r.add(wordList.get(index));
            }
            result.add(r);
            return;
        }

        if (level > maxTransferCount) return;

        int resultCount = 0;
        for (int i = 0; i < beginWord.length(); i++) {
            if (beginWord.charAt(i) != endWord.charAt(i)) resultCount++;
        }

        for (int k = 0; k < wordList.size(); k++) {
            if (resultIndex.contains(k)) continue;

            String word = wordList.get(k);
            if (word.length() != beginWord.length()) {
                continue;
            }

            if (resultCount == 1 && !word.equalsIgnoreCase(endWord)) continue;

            int count = 0;
            for (int i = 0; i < beginWord.length(); i++) {
                if (beginWord.charAt(i) != word.charAt(i)) count++;
            }
            if (count > 1) continue;

            resultIndex.add(k);
            findLadder(word, endWord, wordList, result, resultIndex, maxTransferCount, level + 1);
            resultIndex.remove(resultIndex.size() - 1);
        }

    }

    public static void main(String[] args) {
        System.out.println(findLadders("hit", "cog", Lists.newArrayList("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(findLadders("hot", "dog", Lists.newArrayList("hot", "dog", "dot")));


        System.out.println(findLadders("qa", "sq",
                Lists.newArrayList("si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye")));

    }
}
