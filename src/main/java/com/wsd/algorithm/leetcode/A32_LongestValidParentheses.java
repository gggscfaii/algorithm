package com.wsd.algorithm.leetcode;

import java.util.Stack;

/**
 * A32_LongestValidParentheses
 * Created by sdwang on 2020/1/21 18:15.
 */
public class A32_LongestValidParentheses {

    public static int longestValidParentheses(String s) {

        if (s.length() <= 0) {
            return 0;
        }
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
                continue;
            }

            if (c == ')') {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses("(()())"));
        System.out.println(longestValidParentheses("()(()"));
    }

}
