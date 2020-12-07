package com.wsd.algorithm.basic;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * IntsTest
 * Created by sdwang on 2020/1/16 15:16.
 */
public class IntsTest {

    public static void main(String[] args) {
        System.out.println(Integer.numberOfLeadingZeros(4));
        System.out.println(Integer.numberOfTrailingZeros(4));
        System.out.println(Integer.toBinaryString(~15));

        int a = Integer.MIN_VALUE;
        int b = 1;
        System.out.println((a ^ b) < 0);


        List<String> nums = Lists.newArrayList("1", "2");
        Object o = nums;
        List<String> nums1 = (List<String>) o;
        System.out.println(nums1);

                   /*注意，要想改变默认的排列顺序，不能使用基本类型（int,double, char）
    		           而要使用它们对应的类*/
        Integer[] aa = {9, 8, 7, 2, 3, 4, 1, 0, 6, 5};
        //定义一个自定义类MyComparator的对象
        Comparator cmp = new MyComparator();
        Arrays.sort(aa, cmp);
        for (int arr : aa) {
            System.out.print(arr + " ");
        }
    }

    //实现Comparator接口
    static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
    		        /*如果o1小于o2，我们就返回正值，如果o1大于o2我们就返回负值，
    		         这样颠倒一下，就可以实现降序排序了,反之即可自定义升序排序了*/
            return o2 - o1;

        }
    }
}
