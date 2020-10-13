package com.wsd.algorithm.basic;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * MoveBitTest
 *
 * @author wangshudong
 * @date 2020/7/11
 */
public class MoveBitTest {

    public static void main(String[] args) {
        int x = -5;
        System.out.println(x >> 1);

        List<String> nums = Lists.newArrayList("1", "2");
        Object o = nums;
        List<String> nums1 = (List<String>) o;
        System.out.println(nums1);
    }
}
