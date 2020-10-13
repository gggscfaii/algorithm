package com.wsd.algorithm.basic;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * IntsTest
 * Created by sdwang on 2020/1/16 15:16.
 */
public class IntsTest {

    public static void main(String[] args) {
        System.out.println(Integer.numberOfLeadingZeros(4));
        System.out.println(Integer.numberOfTrailingZeros(4));
        System.out.println(Integer.toBinaryString(~15));

        int a = Integer.MIN_VALUE;
        int b = 1;
        System.out.println((a ^ b) < 0);


        List<String> nums = Lists.newArrayList("1", "2");
        Object o = nums;
        List<String> nums1 = (List<String>) o;
        System.out.println(nums1);
    }
}
