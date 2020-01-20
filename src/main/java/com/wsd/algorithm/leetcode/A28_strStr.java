package com.wsd.algorithm.leetcode;

/**
 * A28_strStr
 * Created by sdwang on 2020/1/20 18:53.
 */
public class A28_strStr {

    public static int strStr(String haystack, String needle) {

        if (needle.length() == 0) {
            return 0;
        }

        char first = needle.charAt(0);
        int max = haystack.length() - needle.length();

        for (int i = 0; i <= max; i++) {
            /* Look for first character. */
            if (haystack.charAt(i) != first) {
                while (++i <= max && haystack.charAt(i) != first) ;
            }

            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + needle.length() - 1;
                for (int k = 1; j < end && haystack.charAt(j)
                        == needle.charAt(k); j++, k++)
                    ;

                if (j == end) {
                    /* Found whole string. */
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("".indexOf(""));
        System.out.println(strStr("abcd", "bc"));
        System.out.println(strStr("mississippi", "pi"));
    }
}
