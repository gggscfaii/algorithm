package com.wsd.algorithm.leetcode.interview;

import java.util.ArrayList;
import java.util.List;

public class A68_文本左右对齐 {

    public static List<String> fullJustify(String[] words, int maxWidth) {

        if (words == null) {
            return new ArrayList<>();
        }

        List<String> lines = new ArrayList<>();
        for (int i = 0; i < words.length; ) {

            int end = i;
            int len = 0;
            while (end < words.length) {
                len += words[end].length();
                len += 1;
                if (len > maxWidth) {
                    break;
                }
                len += 1;
                end++;
            }

            len = 0;
            for (int j = i; j < end; j++) {
                len += words[j].length();
            }

            int spaceCount = end - i - 1;
            int avgSpace = spaceCount > 0 ? (maxWidth - len) / spaceCount : (maxWidth - len);
            int modSpace = spaceCount > 0 ? (maxWidth - len) % spaceCount : 0;
            String line = "";
            for (int j = i; j < end; j++) {
                line += words[j];
                int space;
                if (end == words.length && j != end - 1) {
                    space = 1;
                } else if (j == end - 1) {
                    space = maxWidth - line.length();
                } else {
                    space = avgSpace;
                }
                while (line.length() < maxWidth && space > 0) {
                    line += " ";
                    space--;
                }

                if (end != words.length && modSpace > 0) {
                    line += " ";
                    modSpace--;
                }
            }
            lines.add(line);
            i += (end - i);
        }
        return lines;
    }

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        System.out.println(fullJustify(words, maxWidth));

        words = new String[]{"What", "must", "be", "acknowledgment", "shall", "be"};
        System.out.println(fullJustify(words, maxWidth));

        // [
        // "My    momma   always", "said, \"Life was like", "a box of chocolates.", "You  never know what", "you're gonna get.  "]
        // [
        // "My    momma   always", "said, \"Life was like", "a box of chocolates.", "You  never know what", "you're gonna get.   "]

    }
}
