package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/2/23.
 */
public final class NodeUtil {

    public static Node newNode(Integer nums[]) {

        return newNode(nums, 0);
    }

    public static Node newNode(Integer nums[], int rootIndex) {

        if (rootIndex >= nums.length || nums[rootIndex] == null) {
            return null;
        }

        Node root = new Node(nums[rootIndex]);
        root.left = newNode(nums, rootIndex * 2 + 1);
        root.right = newNode(nums, rootIndex * 2 + 2);
        return root;
    }

    public static void print(Node node) {

        while (node != null) {
            Node leftNode = node;
            while (leftNode != null) {
                System.out.print(leftNode.val + ",");
                leftNode = leftNode.next;
            }
            System.out.println();
            node = node.left;
        }

    }

}
