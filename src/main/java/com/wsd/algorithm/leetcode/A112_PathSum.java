package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/2/23.
 */
public class A112_PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == sum) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
