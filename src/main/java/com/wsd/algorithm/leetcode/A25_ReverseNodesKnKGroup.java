package com.wsd.algorithm.leetcode;

/**
 * A25_ReverseNodesKnKGroup
 * Created by sdwang on 2020/1/20 14:34.
 */
public class A25_ReverseNodesKnKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode dumpy, cur;
        dumpy = new ListNode(-1);
        dumpy.next = head;
        cur = dumpy;
        while (cur != null) {
            cur.next = reverseListNode(cur.next, k);
            for (int i = 0; cur != null && i < k; i++) {
                cur = cur.next;
            }
        }
        return dumpy.next;
    }

    public static ListNode reverseListNode(ListNode head, int k) {
        ListNode end;
        end = head;
        while (end != null && k-- > 0) {
            end = end.next;
        }
        if (k > 0) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy.next;
        while (cur != null && cur.next != end) {
            ListNode node = cur.next;
            cur.next = node.next;
            node.next = dummy.next;
            dummy.next = node;
        }
        return dummy.next;
//        ListNode next, newHead;
//        newHead = end;
//        while (head != end) {
//            next = head.next;
//            head.next = newHead;
//            newHead = head;
//            head = next;
//        }
//        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = reverseKGroup(ListNodeUtil.newListNode(new int[]{1, 2, 3, 4, 5}), 2);
        ListNodeUtil.print(head);
    }
}
