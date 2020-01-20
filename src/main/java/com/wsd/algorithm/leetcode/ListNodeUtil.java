package com.wsd.algorithm.leetcode;

/**
 * ListNodeUtil
 * Created by sdwang on 2020/1/20 14:35.
 */
public class ListNodeUtil {

    public static ListNode newListNode() {
        return new ListNode(-1);
    }

    public static ListNode newListNode(int[] numbers) {
        ListNode root = newListNode();
        ListNode listNode = root;
        for (int num : numbers) {
            listNode.next = new ListNode(num);
            listNode = listNode.next;
        }
        return root.next;
    }

    public static void print(ListNode node) {
        System.out.println(node);
    }
}
