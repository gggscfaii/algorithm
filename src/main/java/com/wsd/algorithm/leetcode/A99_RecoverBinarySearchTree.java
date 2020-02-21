package com.wsd.algorithm.leetcode;

/**
 * A99_RecoverBinarySearchTree
 * Created by sdwang on 2020/2/21 11:20.
 */
public class A99_RecoverBinarySearchTree {


    public static void recoverTree(TreeNode root) {
        inorderTraverse(root);
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
    }

    static TreeNode node1 = null;
    static TreeNode node2 = null;
    static TreeNode prev = null;

    private static void inorderTraverse(TreeNode root) {
        if (root == null)
            return;

        inorderTraverse(root.left);
        if (prev != null) {
            if (root.val < prev.val) {
                if (node1 == null)
                    node1 = prev;
                node2 = root;
            }
        }
        prev = root;
        inorderTraverse(root.right);
    }

    public static void main(String[] args) {
//        TreeNode root = TreeNodeUtil.newTreeNode(new Integer[]{2, 3, null, 5, 1});
//        recoverTree(root);
//        TreeNodeUtil.print(root);

        System.out.println();
        TreeNode root = TreeNodeUtil.newTreeNode(new Integer[]{3, 1, 4, null, null, 2});
        recoverTree(root);
        TreeNodeUtil.print(root);
    }
}
