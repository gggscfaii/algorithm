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


    /*
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    1
    2 3
    4 5 6 7
    8 9 10 11 12 13 14 15
    */
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }

        ArrayList<TreeNode> preLevel = new ArrayList<>();
        preLevel.add(pRoot);

        print(preLevel, result, true);
        return result;
    }

    public static void print(ArrayList<TreeNode> preLevel,
                             ArrayList<ArrayList<Integer>> result,
                             boolean left) {

        if (preLevel.size() <= 0) return;

        ArrayList<Integer> subResult = new ArrayList<>();
        if (left) {
            for (int i = 0; i < preLevel.size(); i++) {
                subResult.add(preLevel.get(i).val);
            }
        } else {
            for (int i = preLevel.size() - 1; i >= 0; i--) {
                subResult.add(preLevel.get(i).val);
            }
        }
        result.add(subResult);

        ArrayList<TreeNode> subRoots = new ArrayList<>();
        for (int i = 0; i < preLevel.size(); i++) {
            TreeNode root = preLevel.get(i);
            if (root.left != null) {
                subRoots.add(root.left);
            }

            if (root.right != null) {
                subRoots.add(root.right);
            }
        }
        print(subRoots, result, !left);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.newTreeNode(new Integer[]{1, 2, 3, 4, null, null, 5});
        System.out.println(zigzagLevelOrder(root));

        root = TreeNodeUtil.newTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(zigzagLevelOrder(root));

        root = TreeNodeUtil.newTreeNode(new Integer[]{1, 2, 3, 4, null, null, 5});
        System.out.println(Print(root));

        root = TreeNodeUtil.newTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(Print(root));

    }

}
