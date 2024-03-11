package com.wsd.algorithm.leetcode.interview;

public class A58最后一个单词的长度 {

    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int start = 0;
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ' || i == s.length() - 1) {
                if (start != -1) {
                    length = i - start + (s.charAt(i) == ' ' ? 0 : 1);
                } else if (s.charAt(i) != ' ') {
                    length = 1;
                }
                start = -1;
            } else if (start == -1) {
                start = i;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(lengthOfLastWord("luffy is still joyboy"));
        System.out.println(lengthOfLastWord("a"));
        System.out.println(lengthOfLastWord(" a"));
        System.out.println(lengthOfLastWord("a "));
    }
}
