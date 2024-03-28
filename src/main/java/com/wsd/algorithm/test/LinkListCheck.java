package com.wsd.algorithm.test;

public class LinkListCheck {

    /**
     * 链表节点
     */
    public static class Node {

        /**
         * 数据索引
         */
        public int index;

        /**
         * 指向下一个节点
         */
        public Node next;
    }


    public static void clearUnReferenceNode(Node roots[]) {

        // 节点为空，直接返回
        if (roots == null || roots.length <= 0) {
            return;
        }

        // 用于记录哪些节点是有引用的，如果有引用则将当前位置标置为1
        int signNodeIndexs[] = new int[roots.length];

        // 循环遍历所有节点
        for (int i = 0; i < roots.length; i++) {

            // 检测当前节点下的所有指向节点
            Node cur = roots[i];

            while (cur.next != null) {

                Node next = cur.next;
                signNodeIndexs[next.index] = 1;

                // 如果是指向自身引用，则直接跳出，不再做下次检测
                if (next == cur) {
                    break;
                }

                if (next.index < i) {
                    break;
                }
                cur = next;
            }
        }

        // 标记清除无引用节点
        for (int i = 0; i < signNodeIndexs.length; i++) {
            if (signNodeIndexs[i] == 1) {
                continue;
            }

            roots[i] = null;
        }

    }

    // 测试1：全部节点都是未引用的
    public static void test_all_node_un_reference() {

        Node roots[] = new Node[5];
        for (int i = 0; i < 5; i++) {
            Node n = new Node();
            roots[i] = n;
            n.index = i;
            n.next = null;
        }

        clearUnReferenceNode(roots);
        for (int i = 0; i < 5; i++) {
            if (roots[i] != null) {
                throw new RuntimeException("测试失败");
            }
        }
    }

    // 测试2：有节点被引用，但没有引用下一个节点
    public static void test_has_node_ref_but_not_have_ref_next_node() {

        Node roots[] = new Node[5];
        for (int i = 0; i < 5; i++) {
            Node n = new Node();
            roots[i] = n;
            n.index = i;
            n.next = null;
        }

        for (int i = 0; i < 4; i += 2) {
            roots[i].next = roots[i + 1];
        }


        clearUnReferenceNode(roots);

        for (int i = 0; i < 4; i += 2) {

            if (roots[i] != null) {
                throw new RuntimeException("测试失败");
            }

            if (roots[i + 1] == null) {
                throw new RuntimeException("测试失败");
            }
        }
    }

    // 测试3：有节点被引用，同时引用下一个节点
    public static void test_has_node_ref_and_have_ref_next_node() {

        Node roots[] = new Node[5];
        for (int i = 0; i < 5; i++) {
            Node n = new Node();
            roots[i] = n;
            n.index = i;
            n.next = null;
        }

        for (int i = 0; i < 4; i++) {
            roots[i].next = roots[i + 1];
        }


        clearUnReferenceNode(roots);

        assert (roots[0] == null);
        for (int i = 1; i < 5; i++) {

            if (roots[i] == null) {
                throw new RuntimeException("测试失败");
            }
        }
    }

    // 测试4：节点引用自身
    public static void test_node_cycle_ref() {

        Node roots[] = new Node[5];
        for (int i = 0; i < 5; i++) {
            Node n = new Node();
            roots[i] = n;
            n.index = i;
            n.next = null;
        }

        for (int i = 0; i < 5; i++) {
            roots[i].next = roots[i];
        }

        clearUnReferenceNode(roots);

        for (int i = 0; i < 5; i++) {
            if (roots[i] == null) {
                throw new RuntimeException("测试失败");
            }
        }
    }

    // 测试5：case2+case3+case4 综合情况
    public static void test_complex_case() {
        Node roots[] = new Node[5];
        for (int i = 0; i < 5; i++) {
            Node n = new Node();
            roots[i] = n;
            n.index = i;
            n.next = null;
        }

        roots[0].next = roots[1];
        roots[4].next = roots[3];
        roots[3].next = roots[1];
        roots[2].next = roots[2];

        clearUnReferenceNode(roots);

        if (roots[0] != null) {
            throw new RuntimeException("测试失败");
        }

        if (roots[1] == null) {
            throw new RuntimeException("测试失败");
        }

        if (roots[2] == null) {
            throw new RuntimeException("测试失败");
        }

        if (roots[3] == null) {
            throw new RuntimeException("测试失败");
        }

        if (roots[4] != null) {
            throw new RuntimeException("测试失败");
        }
    }

    public static void main(String[] args) {
        test_all_node_un_reference();
        test_has_node_ref_but_not_have_ref_next_node();
        test_has_node_ref_and_have_ref_next_node();
        test_node_cycle_ref();
        test_complex_case();
    }
}