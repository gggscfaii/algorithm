package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/2/23.
 */
public class A117_PopulatingNextRightPointersinEachNodeII {

    public static Node connect(Node root) {
        if (root == null) return null;
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else if (root.next != null) {
                root.left.next = root.next.left != null ? root.next.left : root.next.right;
            }
        }

        if (root.right != null) {
            if (root.next != null) {
                root.right.next = root.next.left != null ? root.next.left : root.next.right;
            }
        }
        connect(root.left);
        connect(root.right);
        return root;
    }

    public static void main(String[] args) {
        Node node = NodeUtil.newNode(new Integer[]{1, 2, 3, 4, null, null, 5});
        node = connect(node);
        NodeUtil.print(node);

        node = NodeUtil.newNode(new Integer[]{1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8});
        node = connect(node);
        NodeUtil.print(node);
    }

}
