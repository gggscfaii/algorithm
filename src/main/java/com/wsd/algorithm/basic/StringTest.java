package com.wsd.algorithm.basic;

/**
 * StringTest
 *
 * @author wangshudong
 * @date 2020/11/29
 */
public class StringTest {

    public static void main(String[] args) {
        String a = "abc";
        String b = a + "1";
        String c = a + "1";
        System.out.println(b == c);
    }
}
