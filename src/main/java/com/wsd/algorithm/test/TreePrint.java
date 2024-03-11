package com.wsd.algorithm.test;

import java.util.Stack;

public class TreePrint {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }

    public static void treePrintMethod(TreeNode root, String path) {

        if (root == null) {
            return;
        }

        if (root.getLeft() == null && root.getRight() == null) {
            System.out.println(path + root.getVal());
        }

        treePrintMethod(root.getLeft(), path + root.getVal() + "->");
        treePrintMethod(root.getRight(), path + root.getVal() + "->");
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.setVal(1);

        TreeNode node1 = new TreeNode();
        node1.setVal(2);
        root.setLeft(node1);

        TreeNode node2 = new TreeNode();
        node2.setVal(3);
        root.setRight(node2);

        TreeNode node3 = new TreeNode();
        node3.setVal(4);
        node1.setLeft(node3);

        TreeNode node4 = new TreeNode();
        node4.setVal(5);
        node2.setRight(node4);

        TreeNode node5 = new TreeNode();
        node5.setVal(6);
        node2.setLeft(node5);

        TreeNode node6 = new TreeNode();
        node6.setVal(7);
        node3.setLeft(node6);

        treePrintMethod(root, "");

        Stack<Integer> s = new Stack<>();
    }
}
