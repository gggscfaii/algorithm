package com.wsd.algorithm.leetcode;

/**
 * A137_SingleNumberII
 *
 * @author wangshudong
 * @date 2021/9/30
 */
public class A137_SingleNumberII {

    public static int singleNumber(int[] nums) {

        int ones = 0, twos = 0, threes = 0;
        for (int i = 0; i < nums.length; ++i) {
            threes = twos & nums[i]; //three应该位于第一个，否则第二次遇到1会触发threes=1
            twos |= ones & nums[i];  //表征重复出现1的变量，并且连续按位异或，实现周期性
            ones ^= nums[i]; //将nums不断进行按位异或操作
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }


    public static void main(String[] args) {

        System.out.println(singleNumber(new int[]{3, 4, 5, 6, 7, 4, 5, 6, 7, 4, 5, 6, 7}));

        System.out.println(singleNumber(new int[]{2, 2, 3, 2}));
        System.out.println(singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
    }
}
