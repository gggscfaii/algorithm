package com.wsd.algorithm.leetcode;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
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

