package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/2/16.
 */
public class A82_RemoveDuplicatesfromSortedListII {

    public static ListNode deleteDuplicates(ListNode head) {

        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode pre = fake;
        while (pre.next != null) {
            ListNode cur = pre.next;
            while (cur.next != null && cur.next.val == cur.val) {
                cur = cur.next;
            }

            if (cur != pre.next) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
        }
        return fake.next;
    }

    public static void main(String[] args) {

        ListNodeUtil.print(deleteDuplicates(ListNodeUtil.newListNode(new int[]{1, 1, 1, 2, 2, 3})));
    }
}
