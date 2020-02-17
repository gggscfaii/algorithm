package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/2/12.
 */
public class A61_RotateList {

    public static ListNode rotateRight(ListNode head, int k) {

        if (head == null) return head;
        ListNode node = head;
        int n = 1;
        while (node.next != null) {
            node = node.next;
            n++;
        }

        node.next = head;
        n = n - k % n;
        for (int i = 0; i < n; i++) {
            node = node.next;
        }
        head = node.next;
        node.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNodeUtil.print(rotateRight(ListNodeUtil.newListNode(new int[]{1, 2, 3, 4, 5}), 11));
    }
}
