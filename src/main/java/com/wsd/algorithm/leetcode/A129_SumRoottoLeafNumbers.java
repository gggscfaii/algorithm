package com.wsd.algorithm.leetcode;

/**
 * A129_SumRoottoLeafNumbers
 * Created by sdwang on 2020/3/16 9:34.
 */
public class A129_SumRoottoLeafNumbers {

    public static int sumNumbers(TreeNode root) {

        return sumNumbers(root, 0);
    }

    public static int sumNumbers(TreeNode root, int rootVal) {
        if (root == null) {
            return 0;
        }

        rootVal = rootVal * 10 + root.val;
        if (root.left == null && root.right == null) {
            return rootVal;
        }

        int sum = 0;
        sum += sumNumbers(root.left, rootVal);
        sum += sumNumbers(root.right, rootVal);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumNumbers(TreeNodeUtil.newTreeNode(new Integer[]{1, 2, 3})));
        System.out.println(sumNumbers(TreeNodeUtil.newTreeNode(new Integer[]{4, 9, 0, 5, 1})));
    }
}
