package com.wsd.algorithm.test;

/**
 * @author sdwang
 * @date 2024/11/8
 */
public class StringTest {

    public static void main(String[] args) {

        String s1 = "hello";
        String s2 = s1.intern();
        String s3 = "hello";

        System.out.println(s2 == s3);

        System.out.println(s1== s3 );

    }
}
