package com.wsd.algorithm.leetcode;

/**
 * A124_BinaryTreeMaximumPathSum
 * Created by sdwang on 2020/2/25 10:30.
 */
public class A124_BinaryTreeMaximumPathSum {

    public static int res;

    public static int maxPathSum(TreeNode root) {

        res = Integer.MIN_VALUE;
        dfs(root);
        return res;
    }

    private static int dfs(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int sum = root.val;
        int l = dfs(root.left);
        int r = dfs(root.right);
        if (l > 0) sum += l;
        if (r > 0) sum += r;

        res = Math.max(res, sum);
        int tmp = Math.max(l, r);
        return tmp > 0 ? root.val + tmp : root.val;
    }

    public static void main(String[] args) {
        System.out.println(maxPathSum(TreeNodeUtil.newTreeNode(new Integer[]{1, 2, 3})));
        System.out.println(maxPathSum(TreeNodeUtil.newTreeNode(new Integer[]{-10, 9, 20, null, null, 15, 7})));
    }
}
