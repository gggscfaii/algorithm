package com.wsd.algorithm.leetcode;

/**
 * A138_CopyListwithRandomPointer
 *
 * @author wangshudong
 * @date 2021/9/30
 */
public class A138_CopyListwithRandomPointer {

    /**
     * 1(2) -> 2(3) -> 3(1)
     * first step: 1(2) -> 1(null) -> 2(3) -> 2(null) -> 3(1) -> 3(null)
     * two step:1(2) -> 1(2) -> 2(3) -> 2(3) -> 3(1) -> 3(1)
     * last:断开关系
     *
     * @param head
     * @return
     */
    public static Node copyRandomList(Node head) {

        if (head == null) {
            return head;
        }

        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }

        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        cur = head;
        Node res = cur.next;
        while (cur != null) {
            Node node = cur.next;
            cur.next = node.next;
            if (node.next != null) {
                node.next = node.next.next;
            }
            cur = cur.next;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
