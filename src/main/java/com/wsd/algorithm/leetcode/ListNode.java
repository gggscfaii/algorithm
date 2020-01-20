package com.wsd.algorithm.leetcode;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        ListNode node = this;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (node != null) {
            sb.append(node.val).append(",");
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

