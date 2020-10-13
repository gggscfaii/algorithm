package com.wsd.algorithm.basic;

import com.google.common.collect.Sets;

import java.util.Set;
import java.util.function.Consumer;

/**
 * ConsumerTest
 *
 * @author wangshudong
 * @date 2020/9/11
 */
public class ConsumerTest {
    public static void main(String[] args) {

        Set<Consumer<String>> consumers = Sets.newHashSet();
        for (int i = 0; i < 100; i++) {
            consumers.add(new Consumer<String>() {
                @Override
                public void accept(String s) {

                }
            });
        }

        System.out.println(consumers.size());
    }
}
