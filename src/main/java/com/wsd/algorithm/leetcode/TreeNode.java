package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/2/20.
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
