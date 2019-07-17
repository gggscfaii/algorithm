package com.wsd.algorithm.leetcode;

/**
 * AddTwoNumbers
 * Created by sdwang on 2019/7/17 17:16.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = null, next = null, node;
        boolean flag = false;
        int val;
        while (l1 != null || l2 != null) {
            val = 0;
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }

            if (flag) {
                val++;
            }

            flag = val >= 10;
            node = new ListNode(val % 10);
            if (next == null) {
                root = node;
                next = node;
            } else {
                next.next = node;
                next = node;
            }
        }

        if (flag) {
            node = new ListNode(1);
            next.next = node;
        }
        return root;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode l1, l2;
        int[] arr1 = new int[]{2, 4, 3};
        int[] arr2 = new int[]{5, 6, 4};

        l1 = getListNode(arr1);
        l2 = getListNode(arr2);

        AddTwoNumbers numbers = new AddTwoNumbers();
        ListNode node = numbers.addTwoNumbers(l1, l2);
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
    }

    private static ListNode getListNode(int[] arr) {
        ListNode root, next, node;

        root = next = null;
        for (int num : arr) {
            node = new ListNode(num);
            if (next == null) {
                root = node;
                next = node;
            } else {
                next.next = node;
                next = node;
            }
        }
        return root;
    }
}
