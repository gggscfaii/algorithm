package com.wsd.algorithm.leetcode;

/**
 * A9_PalindromeNumber
 * Created by sdwang on 2019/9/11 18:33.
 */
public class A9_PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(7));
    }

    public static boolean isPalindrome(int x) {

        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int temp = x;
        int reverseX = 0;
        while (temp != 0) {
            reverseX *= 10;
            reverseX += temp % 10;
            temp /= 10;
        }
        return reverseX == x;
    }

}
