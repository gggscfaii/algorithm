package com.wsd.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sdwang on 2020/2/20.
 */
public class A95_UniqueBinarySearchTreesII {

    public static List<TreeNode> generateTrees(int n) {
        return generateTrees(n, new HashSet<>());
    }

    public static List<TreeNode> generateTrees(int n, Set<Integer> nums) {
        List<TreeNode> nodes = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (nums.contains(i)) {
                continue;
            }

            nums.add(i);
            List<TreeNode> subNodes = generateTrees(n, nums);
            if (subNodes.isEmpty()) {
                TreeNode node = new TreeNode(i);
                nodes.add(node);
            }

            for (TreeNode subNode : subNodes) {

                TreeNode node = new TreeNode(i);
                node.left = subNode;
                nodes.add(node);

                node = new TreeNode(i);
                node.right = subNode;
                nodes.add(node);
            }
            nums.remove(i);
        }
        return nodes;
    }

    public static void main(String[] args) {
        List<TreeNode> nodes = generateTrees(3);
        for (TreeNode node : nodes) {
            TreeNodeUtil.print(node);
            System.out.println();
        }
    }
}
