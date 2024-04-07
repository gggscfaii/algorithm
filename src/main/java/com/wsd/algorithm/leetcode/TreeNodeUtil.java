package com.wsd.algorithm.leetcode;

import apple.laf.JRSUIUtils;

/**
 * Created by sdwang on 2020/2/20.
 */
public class TreeNodeUtil {

    public static TreeNode newTreeNode(Integer nums[]) {
        return newTreeNode(nums, 0);
    }

    public static TreeNode newTreeNode(Integer nums[], int rootIndex) {

        if (rootIndex >= nums.length || nums[rootIndex] == null) {
            return null;
        }

        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = newTreeNode(nums, rootIndex * 2 + 1);
        root.right = newTreeNode(nums, rootIndex * 2 + 2);
        return root;
    }

    public static TreeNode findNode(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        TreeNode left = findNode(root.left, val);
        if (left != null) {
            return left;
        }

        TreeNode right = findNode(root.right, val);
        if (right != null) {
            return right;
        }
        return null;
    }

    public static void print(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + ",");
        print(root.left);
        print(root.right);
    }
}
