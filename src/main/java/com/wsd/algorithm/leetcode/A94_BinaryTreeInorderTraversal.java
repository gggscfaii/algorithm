package com.wsd.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sdwang on 2020/2/20.
 */
public class A94_BinaryTreeInorderTraversal {

    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> nodes = new ArrayList<>();
        if (root == null) {
            return nodes;
        }

        nodes.addAll(inorderTraversal(root.left));
        nodes.add(root.val);
        nodes.addAll(inorderTraversal(root.right));
        return nodes;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.newTreeNode(new Integer[]{1, null, 2, 3});
        System.out.println(inorderTraversal(root));
    }

}
