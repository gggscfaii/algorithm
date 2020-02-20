package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/2/20.
 */
public class TreeNodeUtil {

    public static TreeNode newTreeNode(Integer nums[]) {

        TreeNode root = new TreeNode(nums[0]);
        TreeNode head = root;
        for (int i = 1; i < nums.length; i += 2) {
            TreeNode left = null, right = null;
            if (nums[i] != null) {
                left = new TreeNode(nums[i]);
                head.left = left;
            }

            if (i + 1 < nums.length && nums[i + 1] != null) {
                right = new TreeNode(nums[i + 1]);
                head.right = right;
            }

            if (left != null) {
                head = left;
            } else {
                head = right;
            }
        }
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
