package com.wsd.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sdwang on 2020/2/20.
 */
public class A95_UniqueBinarySearchTreesII {

    public static List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return null;
        }

        return generateTrees(1, n);
    }

    public static List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> nodes = new ArrayList<>();
        if (start > end) {
            nodes.add(null);
            return nodes;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftNodes = generateTrees(start, i - 1);
            List<TreeNode> rightNodes = generateTrees(i + 1, end);

            for (TreeNode leftNode : leftNodes) {
                for (TreeNode rightNode : rightNodes) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftNode;
                    node.right = rightNode;
                    nodes.add(node);
                }
            }
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
