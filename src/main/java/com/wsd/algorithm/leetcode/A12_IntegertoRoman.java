package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2019/10/11.
 */
public class A12_IntegertoRoman {

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int n;
        if ((n = num / 1000) > 0) {
            for (int i = 0; i < n; i++) {
                sb.append("M");
            }
            num = num % 1000;
        }

        if ((n = num / 100) > 0) {
            if (n == 9) {
                sb.append("CM");
                n -= 9;
            }

            if (n >= 5) {
                sb.append("D");
                n -= 5;
            }
            if (n == 4) {
                sb.append("CD");
            } else {
                for (int i = 0; i < n; i++) {
                    sb.append("C");
                }
            }
            num = num % 100;
        }

        if ((n = num / 10) > 0) {
            if (n == 9) {
                sb.append("XC");
                n -= 9;
            }

            if (n >= 5) {
                sb.append("L");
                n -= 5;
            }

            if (n == 4) {
                sb.append("XL");
            } else {
                for (int i = 0; i < n; i++) {
                    sb.append("X");
                }
            }
            num = num % 10;
        }

        n = num;
        if (n == 9) {
            sb.append("IX");
            n -= 9;
        }

        if (n >= 5) {
            sb.append("V");
            n -= 5;
        }

        if (n == 4) {
            sb.append("IV");
        } else {
            for (int i = 0; i < n; i++) {
                sb.append("I");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(500));
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
        System.out.println(intToRoman(2994));
    }

}
