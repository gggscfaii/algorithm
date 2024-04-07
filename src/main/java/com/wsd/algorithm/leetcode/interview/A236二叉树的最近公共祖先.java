package com.wsd.algorithm.leetcode.interview;

import com.wsd.algorithm.leetcode.TreeNode;
import com.wsd.algorithm.leetcode.TreeNodeUtil;

public class A236二叉树的最近公共祖先 {

    public TreeNode parentNode = null;

    public boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean lson = findNode(root.left, p, q);
        boolean rson = findNode(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            parentNode = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findNode(root, p, q);
        return parentNode;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeUtil.newTreeNode(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        A236二叉树的最近公共祖先 a236 = new A236二叉树的最近公共祖先();
        System.out.println(a236.lowestCommonAncestor(treeNode, treeNode.left, treeNode.right).toString());

        a236 = new A236二叉树的最近公共祖先();
        System.out.println(a236.lowestCommonAncestor(treeNode, treeNode.left, TreeNodeUtil.findNode(treeNode, 4)).toString());

        a236 = new A236二叉树的最近公共祖先();
        treeNode = TreeNodeUtil.newTreeNode(new Integer[]{1, 2});
        System.out.println(a236.lowestCommonAncestor(treeNode, treeNode, treeNode.left));

    }
}
