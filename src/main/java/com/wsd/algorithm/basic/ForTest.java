package com.wsd.algorithm.basic;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by sdwang on 2019/12/28.
 */
public class ForTest {

    public static void main(String[] args) {
        int nums[] = new int[]{1, 2, 3, 4};
        for (int num : nums) {
            System.out.println(num);
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

        List<Integer> counts = Lists.newArrayList();
        for (int i = 0; i < 1000; i++) {
            counts.add(i);
        }

        List<Integer> counts1 = Lists.newArrayList();
        for (int i = 0; i < 1000; i++) {
            counts.add(counts.get(i));
        }
    }
}
