package com.wsd.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sdwang on 2020/2/22.
 */
public class A107_BinaryTreeLevelOrderTraversalII {

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrderBottom(root, 0, result);
        return result;
    }

    public static void levelOrderBottom(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null) return;

        if (result.size() <= level) {
            result.add(0, new ArrayList<>());
        }

        result.get(result.size() - level - 1).add(root.val);
        levelOrderBottom(root.left, level + 1, result);
        levelOrderBottom(root.right, level + 1, result);
    }

    public static void main(String[] args) {
        System.out.println(levelOrderBottom(TreeNodeUtil.newTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }
}
