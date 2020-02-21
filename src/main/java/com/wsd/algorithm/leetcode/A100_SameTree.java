package com.wsd.algorithm.leetcode;

/**
 * A100_SameTree
 * Created by sdwang on 2020/2/21 17:00.
 */
public class A100_SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if ((p == null) != (q == null)) {
            return false;
        }

        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
