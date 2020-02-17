package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/2/12.
 */
public class A66_PlusOne {

    public static int[] plusOne(int[] digits) {

        int plus = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += plus;
            plus = digits[i] / 10;
            digits[i] = digits[i] % 10;
        }

        if (plus >= 1) {
            int[] plusDigits = new int[digits.length + 1];
            System.arraycopy(digits, 0, plusDigits, 1, digits.length);
            plusDigits[0] = plus;
            return plusDigits;
        }
        return digits;
    }

    public static void main(String[] args) {
        ArrayUtil.print(plusOne(new int[]{1, 2, 3}));
        ArrayUtil.print(plusOne(new int[]{9, 9, 9}));
    }
}
