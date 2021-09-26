package com.wsd.algorithm.basic;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * LinkListTest
 *
 * @author wangshudong
 * @date 2021/8/20
 */
public class LinkListTest {

    public static void main(String[] args) {
        List<Long> uids = Lists.newLinkedList();

        for (int i = 0; i < 5; i++) {
            uids.add((long) i);
        }

        uids.addAll(uids);
        uids.addAll(uids);
        System.out.println(uids);


        List<Long> te = Lists.newLinkedList();
        List<Long> re = null;
        for (int k = 0; k < 10; k++) {
            for (int i = 0; i < 10; i++) {
                te.add(new Long(1234));
            }
            if (re != null && re.size() > 0) {
                re.addAll(te);
            } else {
                re = te;
            }
        }
        System.out.println(re);

    }
}
