package com.wsd.algorithm.basic;

import com.google.common.collect.Lists;

import java.util.ArrayList;

/**
 * StreamTest
 *
 * @author wangshudong
 * @date 2021/12/15
 */
public class StreamTest {

    public static void main(String[] args) {
        ArrayList<Integer> nums = Lists.newArrayList(1, 1, 2, 1);
        System.out.println(nums.stream().noneMatch(n -> n == 1));
    }
}
