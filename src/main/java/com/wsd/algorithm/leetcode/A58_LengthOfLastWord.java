package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/2/10.
 */
public class A58_LengthOfLastWord {

    public static int lengthOfLastWord(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }

        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') i--;

        int count = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
    }
}
