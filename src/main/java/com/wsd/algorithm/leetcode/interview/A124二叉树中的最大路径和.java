package com.wsd.algorithm.leetcode.interview;

import com.wsd.algorithm.leetcode.TreeNode;
import com.wsd.algorithm.leetcode.TreeNodeUtil;

public class A124二叉树中的最大路径和 {

    private static int max_sum = Integer.MIN_VALUE;

    public static int maxPathSum1(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftMaxSum = maxPathSum1(root.left);
        int rightMaxSum = maxPathSum1(root.right);

        int maxSum = leftMaxSum + rightMaxSum + root.val;
        if (maxSum > max_sum) {
            max_sum = maxSum;
        }

        if (root.val > max_sum) {
            max_sum = root.val;
        }

        if (leftMaxSum + root.val > max_sum) {
            max_sum = leftMaxSum + root.val;
        }

        if (rightMaxSum + root.val > max_sum) {
            max_sum = rightMaxSum + root.val;
        }

        if (leftMaxSum <= 0 && rightMaxSum <= 0) {
            return root.val;
        } else if (leftMaxSum > rightMaxSum) {
            return leftMaxSum + root.val;
        } else {
            return rightMaxSum + root.val;
        }
    }

    public static int maxPathSum(TreeNode root) {
        maxPathSum1(root);
        return max_sum;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.newTreeNode(new Integer[]{9, 6, -3, null, null, -6, 2, null, null, 2, null, -6, -6, -6});
        System.out.println(maxPathSum(root));
    }

}
