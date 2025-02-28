package com.wsd.algorithm.leetcode;

import com.google.common.collect.Lists;

import java.util.List;

public class GenerateParetheses {

    public static void generate(int n, int left, int right, String s,List<String> results){
        if(left == n && right == n){
            results.add(s);
            return;
        }

        if(left < n){
            generate(n, left + 1, right, s+"(", results);
        }

        if(left > right && right < n){
            generate(n, left, right + 1, s+")", results);
        }
    }

    public static void main(String[] args) {

        List<String> results = Lists.newArrayList();
        generate(3,0,0,"", results);

        for(String s : results){
            System.out.println(s);
        }
    }
}
