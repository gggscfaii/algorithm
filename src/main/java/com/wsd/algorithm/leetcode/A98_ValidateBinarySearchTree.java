package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/2/21.
 */
public class A98_ValidateBinarySearchTree {

    public static TreeNode last = null;

    public static boolean isValidBST1(TreeNode root) {
        if (root == null)
            return true;
        else {
            boolean leftRes = isValidBST1(root.left);
            //short cut
            if (!leftRes)
                return false;
            if (last != null && last.val >= root.val)
                return false;
            last = root;
            return isValidBST1(root.right);
        }
    }

    public static boolean isValidBST(TreeNode root, int mn, int mx) {
        if (root == null) {
            return true;
        }

        if (root.val <= mn) {
            return false;
        }

        if (root.val >= mx) {
            return false;
        }
        return isValidBST(root.left, mn, root.val) && isValidBST(root.right, root.val, mx);
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        System.out.println(isValidBST1(TreeNodeUtil.newTreeNode(new Integer[]{10, 5, 15, null, null, 6, 20})));
        System.out.println(isValidBST(TreeNodeUtil.newTreeNode(new Integer[]{10, 5, 15, null, null, 6, 20})));
    }

}
