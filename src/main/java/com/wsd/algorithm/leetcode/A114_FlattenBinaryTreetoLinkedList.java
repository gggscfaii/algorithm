package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/2/23.
 */
public class A114_FlattenBinaryTreetoLinkedList {

    public static void flatten(TreeNode root) {

        if (root == null) return;

        TreeNode right = root.right;
        TreeNode left = root.left;
        flatten(left);
        flatten(right);

        if (left != null) {
            TreeNode lastLeftRight = left;
            while (lastLeftRight.right != null) lastLeftRight = lastLeftRight.right;
            lastLeftRight.right = right;
            root.left = null;
            root.right = left;
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.newTreeNode(new Integer[]{1, 2, 5, 3, 4, null, 6});
        flatten(root);
        TreeNodeUtil.print(root);
    }

}
