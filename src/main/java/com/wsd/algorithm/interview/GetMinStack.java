package com.wsd.algorithm.interview;

import java.util.Stack;

/**
 * GetMinStack
 *
 * @author wangshudong
 * @date 2021/6/15
 */
public class GetMinStack {

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public int[] getMinStack(int[][] op) {

        if (op == null || op.length == 0) {
            return new int[0];
        }

        int[] minNums = new int[op.length];
        int i = 0;
        for (int[] nums : op) {

            switch (nums[0]) {
                case 1:
                    push(nums[1]);
                    break;
                case 2:
                    pop();
                    break;
                case 3:
                    minNums[i++] = getMin();
                    break;
                default:
                    break;
            }
        }
        return minNums;
    }

    private int getMin() {
        return s2.peek();
    }

    private void pop() {
        Integer num = s1.pop();
        if (s2.size() > 0 && num.equals(s2.peek())) {
            s2.pop();
        }
    }

    private void push(int num) {
        s1.push(num);
        if (s2.empty() || s2.peek() > num) {
            s2.push(num);
        }
    }


}
