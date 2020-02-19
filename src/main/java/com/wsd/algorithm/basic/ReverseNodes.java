package com.wsd.algorithm.basic;

import com.wsd.algorithm.leetcode.ListNode;
import com.wsd.algorithm.leetcode.ListNodeUtil;

/**
 * ReverseNodes
 * Created by sdwang on 2020/2/19 13:52.
 */
public class ReverseNodes {

    public static void main(String[] args) {

        ListNode head = ListNodeUtil.newListNode(new int[]{1, 2, 3, 4});
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        ListNodeUtil.print(newHead);

        ListNode dummy = new ListNode(-1);
        dummy.next = newHead;
        ListNode cur = dummy.next;
        while (cur != null && cur.next != null) {
            ListNode node = cur.next;
            cur.next = node.next;
            node.next = dummy.next;
            dummy.next = node;
        }
        ListNodeUtil.print(dummy.next);
    }
}
