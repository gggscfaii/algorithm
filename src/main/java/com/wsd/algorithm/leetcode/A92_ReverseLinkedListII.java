package com.wsd.algorithm.leetcode;

/**
 * A92_ReverseLinkedListII
 * Created by sdwang on 2020/2/19 10:03.
 */
public class A92_ReverseLinkedListII {

    public static ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;
        for (int i = m; i < n; i++) {
            ListNode node = cur.next;
            cur.next = node.next;
            node.next = pre.next;
            pre.next = node;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNodeUtil.print(reverseBetween(ListNodeUtil.newListNode(new int[]{1, 2, 3, 4, 5}), 2, 4));
    }
}
