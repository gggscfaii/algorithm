package com.wsd.algorithm.basic;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by sdwang on 2020/3/16.
 */
public class LruTest {

    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> lruCache = new LinkedHashMap<Integer, Integer>() {

            private int maxSize = 100;

            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > maxSize;
            }
        };

        for (int i = 0; i < 1000; i++) {
            lruCache.put(i, i);
        }

        for (Map.Entry<Integer, Integer> entry : lruCache.entrySet()) {
            System.out.println(entry.getValue());
        }

    }
}
