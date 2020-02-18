package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/2/17.
 */
public class A86_PartitionList {

    public static ListNode partition(ListNode head, int x) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy.next;
        ListNode pre = dummy;
        ListNode pos = null;
        while (cur != null) {

            if (pos != null && cur.val < x) {
                pre.next = cur.next;
                cur.next = pos.next;
                pos.next = cur;
                pos = pos.next;
                cur = pre.next;
            } else {
                if (pos == null && cur.val >= x) {
                    pos = pre;
                }
                pre = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNodeUtil.print(partition(ListNodeUtil.newListNode(new int[]{1, 4, 3, 2, 5, 2}), 3));
        ListNodeUtil.print(partition(ListNodeUtil.newListNode(new int[]{1}), 3));
        ListNodeUtil.print(partition(ListNodeUtil.newListNode(new int[]{1, 4, 2}), 3));

    }
}
