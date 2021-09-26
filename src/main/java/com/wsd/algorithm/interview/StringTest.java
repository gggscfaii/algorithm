package com.wsd.algorithm.interview;

import java.util.HashSet;
import java.util.Set;

/**
 * StringTest
 *
 * @author wangshudong
 * @date 2021/9/26
 */
public class StringTest {

    public static void main(String[] args) {
        char[] c1 = "aba".toCharArray();

        Set<Character> set = new HashSet<>();

        for(char c: c1 ){
            if(set.contains(c)){
                // set.remove(c);
                continue;
            }else{
                set.add(c);
            }
        }
        if(set.size()<=1){
            System.out.println("NO");
        }else{
            System.out.println("YES");
        }

    }
}
