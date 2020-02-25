package com.wsd.algorithm.leetcode;

/**
 * A125_ValidPalindrome
 * Created by sdwang on 2020/2/25 11:00.
 */
public class A125_ValidPalindrome {

    public static boolean isPalindrome(String s) {

        if (s.length() == 0) return true;
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (!isAlphanumeric(s.charAt(left))) {
                left++;
                continue;
            }

            if (!isAlphanumeric(s.charAt(right))) {
                right--;
                continue;
            }

            if (s.charAt(left) == s.charAt(right)
                    || Character.toLowerCase(s.charAt(left)) == s.charAt(right)
                    || Character.toLowerCase(s.charAt(right)) == s.charAt(left)) {
                left++;
                right--;
                continue;
            }

            return false;
        }
        return true;
    }

    public static boolean isAlphanumeric(char c) {
        return c >= 'A' && c <= 'Z'
                || c >= '0' && c <= '9'
                || c >= 'a' && c <= 'z';
    }

    public static void main(String[] args) {

        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome("0P"));
    }

}
