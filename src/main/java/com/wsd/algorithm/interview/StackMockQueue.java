package com.wsd.algorithm.interview;

import java.util.Stack;

public class StackMockQueue {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();


    public void push(int val) {
        stack1.push(val);
    }


    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }


    public static void main(String[] args) {
        StackMockQueue queue = new StackMockQueue();

        queue.push(1);
        queue.push(2);
        System.out.println(queue.pop());
        queue.push(3);
        queue.push(4);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.push(5);
        System.out.println(queue.pop());

    }
}
