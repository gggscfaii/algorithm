package com.wsd.algorithm.leetcode.interview;

import java.util.HashMap;
import java.util.Map;

public class A13罗马数字转整数 {

    public static int romanToInt(String s) {

        Map<String, Integer> mapping = new HashMap<>();
        mapping.put("I", 1);
        mapping.put("V", 5);
        mapping.put("X", 10);
        mapping.put("L", 50);
        mapping.put("C", 100);
        mapping.put("D", 500);
        mapping.put("M", 1000);
        mapping.put("IV", 4);
        mapping.put("IX", 9);
        mapping.put("XL", 40);
        mapping.put("XC", 90);
        mapping.put("CD", 400);
        mapping.put("CM", 900);

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I' && i < s.length() - 1 && mapping.get(s.substring(i, i + 2)) != null) {
                sum += mapping.get(s.substring(i, i + 2));
                i++;
                continue;
            }

            if (s.charAt(i) == 'X' && i < s.length() - 1 && mapping.get(s.substring(i, i + 2)) != null) {
                sum += mapping.get(s.substring(i, i + 2));
                i++;
                continue;
            }

            if (s.charAt(i) == 'C' && i < s.length() - 1 && mapping.get(s.substring(i, i + 2)) != null) {
                sum += mapping.get(s.substring(i, i + 2));
                i++;
                continue;
            }

            sum += mapping.get(s.substring(i, i + 1));
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }
}
