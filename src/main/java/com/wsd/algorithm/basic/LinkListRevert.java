package com.wsd.algorithm.basic;

/**
 * LinkListReverter
 *
 * @author wangshudong
 * @date 2021/4/19
 */
public class LinkListRevert {

    public static class Node {

        public int value;

        public Node(int value) {
            this.value = value;
        }

        public Node next;

    }

    public static void main(String[] args) {

        int[] arr = new int[]{3, 5, 8, 10};
        Node dummy = new Node(-1);
        Node cur = dummy;
        for (int i : arr) {
            Node node = new Node(i);
            cur.next = node;
            cur = node;
        }

        // Node dummy1 = new Node(-1);
        // cur = dummy.next;
        // while (cur != null) {
        //     Node temp = cur.next;
        //     cur.next = dummy1.next;
        //     dummy1.next = cur;
        //     cur = temp;
        // }

        Node prev = dummy.next;
        cur = prev.next;
        while (cur != null) {
            prev.next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = prev.next;
        }

        cur = dummy.next;
        while (cur != null) {
            System.out.println(cur.value);
            cur = cur.next;
        }
    }
}
