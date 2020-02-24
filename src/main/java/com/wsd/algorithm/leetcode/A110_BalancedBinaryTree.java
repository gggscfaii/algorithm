package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/2/23.
 */
public class A110_BalancedBinaryTree {

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        if (treeDepth(root) == -1) return false;
        return true;
    }

    public static int treeDepth(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = treeDepth(root.left);
        if (leftDepth == -1) return -1;

        int rightDepth = treeDepth(root.right);
        if (rightDepth == -1) return -1;

        if (Math.abs(leftDepth - rightDepth) > 1) return -1;
        else return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        System.out.println(isBalanced(TreeNodeUtil.newTreeNode(new Integer[]{1, 2, 2, 3, null, null, 3, 4, null, null, 4})));
        System.out.println(isBalanced(TreeNodeUtil.newTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }
}
