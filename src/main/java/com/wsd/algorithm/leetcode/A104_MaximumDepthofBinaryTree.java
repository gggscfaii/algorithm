package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/2/22.
 */
public class A104_MaximumDepthofBinaryTree {

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.newTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(maxDepth(root));

    }
}
