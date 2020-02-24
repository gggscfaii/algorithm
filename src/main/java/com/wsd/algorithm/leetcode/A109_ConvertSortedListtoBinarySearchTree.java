package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/2/22.
 */
public class A109_ConvertSortedListtoBinarySearchTree {

    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) return new TreeNode(head.val);

        ListNode last = head, slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            last = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = slow.next;
        last.next = null;
        TreeNode root = new TreeNode(slow.val);
        if (head != slow)
            root.left = sortedListToBST(head);
        root.right = sortedListToBST(fast);
        return root;
    }

    public static void main(String[] args) {
        TreeNodeUtil.print(sortedListToBST(ListNodeUtil.newListNode(new int[]{-10, -3, 0, 5, 9})));
    }

}
