package com.wsd.algorithm.test;

import java.util.TreeMap;

public class TreeMapTest {

    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(3, 3);
        map.put(4, 4);
        map.put(1, 1);
        map.put(2, 2);

        for (Integer key : map.keySet()) {
            System.out.println(key);
        }
    }
}
