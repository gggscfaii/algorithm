package com.wsd.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 需要改进性能，不要重复创建子路径
 * Created by sdwang on 2020/2/23.
 */
public class A113_PathSumII {

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> sums = new ArrayList<>();
        if (root == null) return sums;
        if (root.left == null && root.right == null && root.val == sum) {
            List<Integer> subSum = new ArrayList<>();
            subSum.add(root.val);
            sums.add(subSum);
            return sums;
        }

        List<List<Integer>> pathSums = pathSum(root.left, sum - root.val);
        for (List<Integer> pathSum : pathSums) {
            List<Integer> subSum = new ArrayList<>();
            subSum.add(root.val);
            subSum.addAll(pathSum);
            sums.add(subSum);
        }

        pathSums = pathSum(root.right, sum - root.val);
        for (List<Integer> pathSum : pathSums) {
            List<Integer> subSum = new ArrayList<>();
            subSum.add(root.val);
            subSum.addAll(pathSum);
            sums.add(subSum);
        }
        return sums;
    }

    public static void main(String[] args) {
        System.out.println(pathSum(TreeNodeUtil.newTreeNode(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1}), 22));
    }


}
