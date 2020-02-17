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
        while (cur != null) {
            if (cur.val < x) {
                ListNode temp = pre.next;
                pre.next = cur;
                pre = pre.next;
                left.next = cur;
                pre = pre.next;
                cur.next = temp;
                left = left.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNodeUtil.print(partition(ListNodeUtil.newListNode(new int[]{1, 4, 3, 2, 5, 2}), 3));
    }
}
