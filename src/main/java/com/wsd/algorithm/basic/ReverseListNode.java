package com.wsd.algorithm.basic;

import com.wsd.algorithm.leetcode.ListNode;
import com.wsd.algorithm.leetcode.ListNodeUtil;

/**
 * ReverseListNode
 * Created by sdwang on 2020/3/6 9:56.
 */
public class ReverseListNode {


    public static ListNode reverse(ListNode head) {

        ListNode current, newHead;
        current = head;
        newHead = null;
        while (current != null) {
            ListNode node = current.next;
            current.next = newHead;
            newHead = current;
            current = node;
        }

        return newHead;
    }

    public static ListNode reverse1(ListNode head) {

        ListNode current;
        ListNode dumpy = new ListNode(-1);
        dumpy.next = head;
        current = dumpy.next;
        while (current != null && current.next != null) {
            ListNode node = current.next;
            current.next = node.next;
            node.next = dumpy.next;
            dumpy.next = node;
        }

        return dumpy.next;
    }

    public static void main(String[] args) {
        ListNodeUtil.print(reverse(null));
        ListNodeUtil.print(reverse(ListNodeUtil.newListNode(new int[]{1})));
        ListNodeUtil.print(reverse(ListNodeUtil.newListNode(new int[]{1, 2, 3, 4, 5})));

        ListNodeUtil.print(reverse1(null));
        ListNodeUtil.print(reverse1(ListNodeUtil.newListNode(new int[]{1})));
        ListNodeUtil.print(reverse1(ListNodeUtil.newListNode(new int[]{1, 2})));
        ListNodeUtil.print(reverse1(ListNodeUtil.newListNode(new int[]{1, 2, 3, 4, 5})));

    }
}
