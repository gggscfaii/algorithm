package com.wsd.algorithm.leetcode;

/**
 * A23_MergeKsortedLists
 * Created by sdwang on 2020/1/20 10:11.
 */
public class A23_MergeKsortedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKListsOneByOne(ListNode[] lists) {
        if (lists == null) {
            return null;
        }

        ListNode root = new ListNode(0);
        ListNode head = root;
        while (true) {
            int minVal = Integer.MAX_VALUE;
            int index = 0;
            ListNode nextNode = null;
            for (int i = 0; i < lists.length; i++) {
                ListNode node = lists[i];
                if (node == null) {
                    continue;
                }

                if (minVal > node.val) {
                    index = i;
                    minVal = node.val;
                    nextNode = node;
                }
            }

            if (nextNode == null) {
                break;
            }

            head.next = nextNode;
            lists[index] = nextNode.next;
            head = head.next;
        }

        return root.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int interval = 1, len = lists.length;
        while (interval < len) {
            for (int i = 0; i < len - interval; i += 2*interval) {
                lists[i] = merge2Lists(lists[i], lists[i + interval]);
            }
            interval = interval * 2;
        }
        return lists[0];
    }

    public ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode head, next;
        head = next = new ListNode(0);
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                next.next = l1;
                l1 = l1.next;
            } else {
                next.next = l2;
                l2 = l2.next;
            }
            next = next.next;
        }

        if(l1!=null){
            next.next = l1;
        }
        else{
            next.next = l2;
        }
        return head.next;
    }
}