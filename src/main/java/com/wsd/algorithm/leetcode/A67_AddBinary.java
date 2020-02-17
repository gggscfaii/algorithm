package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/2/12.
 */
public class A67_AddBinary {

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int bit = 0, bita, bitb;
        int alen = a.length(), blen = b.length();
        for (int i = 0; i < alen || i < blen; i++) {

            bita = 0;
            bitb = 0;
            if (i < alen) {
                bita = a.charAt(alen - 1 - i) - '0';
            }

            if (i < b.length()) {
                bitb = b.charAt(blen - 1 - i) - '0';
            }

            bit = bit + bita + bitb;
            sb.insert(0, bit % 2);
            bit /= 2;
        }

        if (bit > 0) {
            sb.insert(0, bit);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("111", "111"));
        System.out.println(addBinary("111", "110"));
        System.out.println(addBinary("111", "10"));
        System.out.println(addBinary("111", "0"));
    }

}
