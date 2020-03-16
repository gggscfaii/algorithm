package com.wsd.algorithm.basic;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Created by sdwang on 2020/3/16.
 */
public class JvmReferenceTest {


    public static void main(String[] args) {
        Integer o1 = 1000;
        SoftReference<Integer> softReference = new SoftReference<>(o1);
        o1 = null;
        System.gc();
        System.out.println(softReference.get());

        Integer o2 = 2000;
        WeakReference<Integer> weakReference = new WeakReference<>(o2);
        o2 = null;
        System.gc();
        System.out.println(weakReference.get());

    }
}
