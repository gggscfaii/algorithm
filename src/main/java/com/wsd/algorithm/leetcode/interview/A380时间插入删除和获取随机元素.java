package com.wsd.algorithm.leetcode.interview;

import java.util.HashSet;
import java.util.Set;

public class A380时间插入删除和获取随机元素 {

    public class RandomizedSet {

        private Set<Integer> numSet = new HashSet<>();

        public RandomizedSet() {

        }

        public boolean insert(int val) {
            return numSet.add(val);
        }

        public boolean remove(int val) {
            return numSet.remove(val);
        }

        public int getRandom() {
            Object[] array = numSet.toArray();
            return (int) array[(int) (Math.random() * array.length)];
        }

    }


}
