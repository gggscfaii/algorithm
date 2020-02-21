package com.wsd.algorithm.leetcode;

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

    public static void print(TreeNode root) {
        if (root == null) {
            System.out.print("null,");
            return;
        }

        System.out.print(root.val + ",");
        print(root.left);
        print(root.right);
    }
}
