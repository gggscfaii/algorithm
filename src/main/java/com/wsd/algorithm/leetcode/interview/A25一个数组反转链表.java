package com.wsd.algorithm.leetcode.interview;

import com.wsd.algorithm.leetcode.ListNode;
import com.wsd.algorithm.leetcode.ListNodeUtil;

public class A25一个数组反转链表 {

    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(-1);
        ListNode dummyNextNode = dummy.next;

        while (head != null) {
            ListNode start = head;
            int count = 0;
            while (head != null && count < k) {
                head = head.next;
                count++;
            }

            if (count < k) {
                if (dummyNextNode == null) {
                    dummy.next = start;
                } else {
                    dummyNextNode.next = start;
                }
                continue;
            }

            ListNode dummy1 = new ListNode(-1);
            ListNode lastNode = start;
            while (start != null && start != head) {
                ListNode next = dummy1.next;
                dummy1.next = start;

                start = start.next;
                dummy1.next.next = next;
            }

            if (dummyNextNode == null) {
                dummy.next = dummy1.next;
            } else {
                dummyNextNode.next = dummy1.next;
            }
            dummyNextNode = lastNode;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNodeUtil.newListNode(new int[]{1, 2, 3, 4, 5});
        ListNodeUtil.print(reverseKGroup(listNode, 2));
    }
}
