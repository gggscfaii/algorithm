package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/2/23.
 */
public class A116_PopulatingNextRightPointersinEachNode {

    public static Node connect(Node root) {

        if (root == null) return null;
        if (root.left != null) root.left.next = root.right;
        if (root.right != null) root.right.next = root.next != null ? root.next.left : null;
        connect(root.left);
        connect(root.right);
        return root;
    }


    public static void main(String[] args) {
        Node node = NodeUtil.newNode(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        node = connect(node);
        NodeUtil.print(node);
    }

}
