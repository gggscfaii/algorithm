package com.wsd.algorithm.basic;

import java.util.HashMap;

/**
 * HashMapTest
 * Created by sdwang on 2020/2/26 10:07.
 */
public class HashMapTest {


    public static void main(String[] args) {

        HashMap<Student, Integer> cache = new HashMap<>();
        for (int i = 0; i < 100; i++) {

            Student s = new Student();
            cache.put(s, i);
        }

        System.out.println(cache.get(new Student()));
        System.out.println(cache);

        f();
    }

    public static void f() {
        String[] a = new String[2];
        Object[] b = a;
        a[0] = "hi";
        System.out.println(a);
        b[1] = Integer.valueOf(42);
    }

    public static class Student {
        private String name;

        @Override
        public int hashCode() {
            return 1;
        }
    }
}
