package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/2/23.
 */
public class A111_MinimumDepthofBinaryTree {

    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return 1 + minDepth(root.right);
        if (root.right == null) return 1 + minDepth(root.left);
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        System.out.println(minDepth(TreeNodeUtil.newTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }
}
