package com.wsd.algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * A102_BinaryTreeLevelOrderTraversal
 * Created by sdwang on 2020/2/21 17:44.
 */
public class A102_BinaryTreeLevelOrderTraversal {

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        int count = 1, add = 0;

        queue.add(root);
        List<Integer> subResult = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (count == 0) {
                result.add(subResult);
                subResult = new ArrayList<>();
                count = add;
                add = 0;
            }

            subResult.add(node.val);
            if (node.left != null) {
                add++;
                queue.add(node.left);
            }

            if (node.right != null) {
                add++;
                queue.add(node.right);
            }
            count--;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.newTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(levelOrder(root));
    }
}
