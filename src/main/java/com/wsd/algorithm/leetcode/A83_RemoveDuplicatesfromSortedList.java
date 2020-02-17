package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/2/16.
 */
public class A83_RemoveDuplicatesfromSortedList {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode pre = fake;
        while (pre.next != null) {
            ListNode cur = pre.next.next;
            if (cur != null && cur.val == pre.next.val) {
                pre.next = cur;
            } else {
                pre = pre.next;
            }
        }
        return fake.next;
    }

    public static void main(String[] args) {
        ListNodeUtil.print(deleteDuplicates(ListNodeUtil.newListNode(new int[]{1, 1, 1, 2, 2, 3})));
        ListNodeUtil.print(deleteDuplicates(ListNodeUtil.newListNode(new int[]{1, 1, 1})));

    }
}
