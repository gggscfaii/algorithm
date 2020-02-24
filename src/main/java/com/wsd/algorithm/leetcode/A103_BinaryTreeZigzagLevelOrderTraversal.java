package com.wsd.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sdwang on 2020/2/21.
 */
public class A103_BinaryTreeZigzagLevelOrderTraversal {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        orderLevel(root, result, 0);
        return result;
    }

    public static void orderLevel(TreeNode root, List<List<Integer>> result, int level) {
        if (root == null) {
            return;
        }

        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }

        if (level % 2 == 0) {
            result.get(level).add(root.val);
        } else {
            result.get(level).add(0, root.val);
        }
        orderLevel(root.left, result, level + 1);
        orderLevel(root.right, result, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.newTreeNode(new Integer[]{1, 2, 3, 4, null, null, 5});
        System.out.println(zigzagLevelOrder(root));

        root = TreeNodeUtil.newTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(zigzagLevelOrder(root));

    }

}
