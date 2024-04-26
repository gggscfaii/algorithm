package com.wsd.algorithm.test3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LinkListNode<T> {

    public LinkListNode(T data) {
        this.data = data;
    }

    private T data;

    private LinkListNode<T> left;

    private LinkListNode<T> right;

    private LinkListNode<T> parent;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LinkListNode<T> getLeft() {
        return left;
    }

    public void setLeft(LinkListNode<T> left) {
        this.left = left;
    }

    public LinkListNode<T> getRight() {
        return right;
    }

    public void setRight(LinkListNode<T> right) {
        this.right = right;
    }

    public LinkListNode<T> getParent() {
        return parent;
    }

    public void setParent(LinkListNode<T> parent) {
        this.parent = parent;
    }

    public void generateLinkList(int n, LinkListNode<Integer> node) {

        if (n == 1) {
            return;
        }

        LinkListNode<Integer> left = new LinkListNode<>(node.data * 2);
        generateLinkList(n - 1, left);
        node.setLeft(left);
        left.setParent(node);

        LinkListNode<Integer> right = new LinkListNode<>(node.data * 2 + 1);
        generateLinkList(n - 1, right);
        node.setRight(right);
        right.setParent(node);
    }

    public static LinkListNode<Integer> generateLinkList(int n) {
        LinkListNode<Integer> node = new LinkListNode<>(1);
        node.generateLinkList(n, node);
        return node;
    }

    public boolean nodeIsTree(LinkListNode<Integer> root, LinkListNode<Integer> targetNode) {

        if (root == null) {
            return false;
        }

        if (root == targetNode) {
            return true;
        }

        if (nodeIsTree(root.getLeft(), targetNode)) {
            return true;
        }

        if (nodeIsTree(root.getRight(), targetNode)) {
            return true;
        }

        return false;
    }

    public List<LinkListNode<Integer>> findMinRootPath(LinkListNode<Integer> root,
                                                       LinkListNode<Integer> start,
                                                       LinkListNode<Integer> end) {

        LinkListNode<Integer> next = root;
        boolean startFlag = false, endFlag = false;

        LinkListNode<Integer> startTree = null;
        LinkListNode<Integer> endTree = null;

        while (next != null) {

            if (!startFlag) {
                startFlag = nodeIsTree(next, start);

                if (startFlag) {
                    startTree = next;
                }
            }

            if (!endFlag) {
                endFlag = nodeIsTree(next, end);

                if (endFlag) {
                    endTree = next;
                }
            }

            next = next.getParent();
            if (next == root) {
                break;
            }
        }

        if (startTree == null || endTree == null) {
            return Collections.emptyList();
        }

        LinkListNode<Integer> startParent = null, endParent = null;

        if (startTree == endTree) {

            startParent = start;
            endParent = end;

            while (startParent != endParent) {

                if (startParent != startTree) {
                    startParent = startParent.getParent();
                }

                if (endParent != endTree) {
                    endParent = endParent.getParent();
                }
            }
        } else {
            startParent = startTree;
            endParent = endTree;
        }

        List<LinkListNode<Integer>> result = new ArrayList<>();
        next = start;
        while (next != startParent) {
            result.add(next);
            next = next.getParent();
        }
        result.add(next);

        List<LinkListNode<Integer>> result1 = new ArrayList<>();
        next = end;
        while (next != endParent) {
            result1.add(next);
            next = next.getParent();
        }
        if (startTree != endTree){
            result1.add(next);
        }

        for (int i = result1.size() - 1; i >= 0; i--) {
            result.add(result1.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        LinkListNode<Integer> root1 = generateLinkList(4);
        LinkListNode<Integer> root2 = generateLinkList(4);
        LinkListNode<Integer> root3 = generateLinkList(4);

        root1.setParent(root2);
        root2.setParent(root3);
        root3.setParent(root1);

        LinkListNode<Integer> start = root1.getLeft();
        LinkListNode<Integer> end = root2.getRight();

        LinkListNode<Integer> test = new LinkListNode<>(1);
        List<LinkListNode<Integer>> paths = test.
                findMinRootPath(root1, start, end);
        for (LinkListNode<Integer> path : paths) {
            System.out.print(path.getData() + ",");
        }

        System.out.println("");
        System.out.println("--------");

        start = root1.getLeft();
        end = root1.getRight();
        paths = test.findMinRootPath(root1, start, end);
        for (LinkListNode<Integer> path : paths) {
            System.out.print(path.getData() + ",");
        }
    }
}
