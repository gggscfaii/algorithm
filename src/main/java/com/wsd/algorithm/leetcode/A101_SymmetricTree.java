package com.wsd.algorithm.leetcode;

/**
 * A101_SymmetricTree
 * Created by sdwang on 2020/2/21 17:14.
 */
public class A101_SymmetricTree {

    public static boolean isSymmetric(TreeNode root) {
        return isSameTree(root.left, root.right);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if ((p == null) != (q == null)) {
            return false;
        }

        if (p.val != q.val) return false;

        return isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
    }

    public static void main(String[] args) {
        System.out.println(isSymmetric(TreeNodeUtil.newTreeNode(new Integer[]{1, 2, 2, 3, 4, 4, 3})));
    }
}
