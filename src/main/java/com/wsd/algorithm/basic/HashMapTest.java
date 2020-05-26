package com.wsd.algorithm.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**
 * HashMapTest
 * Created by sdwang on 2020/2/26 10:07.
 */
public class HashMapTest {


    public static void main(String[] args) {

        HashMap<Student, Integer> cache = new HashMap<>();
        for (int i = 0; i < 100; i++) {

            Student s = new Student();
            s.name = String.valueOf(i);

            cache.put(s, i);
        }

        Iterator<Map.Entry<Student, Integer>> iterator = cache.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Student, Integer> entry = iterator.next();
            if (Integer.parseInt(entry.getKey().name) % 2 == 1) {
                iterator.remove();
            } else {
                cache.put(entry.getKey(), entry.getValue());
            }
        }

        iterator = cache.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Student, Integer> entry = iterator.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        Student student = new Student();
        student.name = "1";
        System.out.println(cache.get(student));
        System.out.println(cache.size());
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return Objects.equals(name, student.name);
        }
    }
}
