package com.wsd.algorithm.test;

import com.google.common.collect.Lists;

import java.util.*;

public class DdTest {

    public static void pernum(int nums[], int start, List<List<Integer>> res) {

        if (start == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            res.add(list);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            int temp = nums[i];
            nums[i] = nums[start];
            nums[start] = temp;

            pernum(nums, start + 1, res);

            temp = nums[i];
            nums[i] = nums[start];
            nums[start] = temp;
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }
        // 从 1 开始是题目的设定
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, res);
        return res;
    }

    private static void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        // 递归终止条件是：path 的长度等于 k
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 遍历可能的搜索起点
        for (int i = begin; i <= n; i++) {
            // 向路径变量里添加一个数
            path.addLast(i);
            // 下一轮搜索，设置的搜索起点要加 1，因为组合数理不允许出现重复的元素
            dfs(n, k, i + 1, path, res);
            // 重点理解这里：深度优先遍历有回头的过程，因此递归之前做了什么，递归之后需要做相同操作的逆向操作
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3};

        List<List<Integer>> res = Lists.newArrayList();
        pernum(nums, 0, res);
        System.out.println(res);

        System.out.println(combine(4, 3));
    }
}
