package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/1/23.
 */
public class A38_CountAndSay {

    public static String countAndSay(int n) {

        if (n == 1) {
            return "1";
        }

        String res = countAndSay(n - 1) + "*";
        StringBuilder say = new StringBuilder();
        int count = 1;
        for (int i = 0; i < res.length() - 1; i++) {
            if (res.charAt(i) == res.charAt(i + 1)) {
                count++;
            } else {
                say.append(String.valueOf(count)).append(res.charAt(i));
                count = 1;
            }
        }
        return say.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(6));

    }
}
