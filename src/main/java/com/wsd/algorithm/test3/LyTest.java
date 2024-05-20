package com.wsd.algorithm.test3;

public class LyTest {

    public static class Node {
        public int val;

        public Node pre;

        public Node next;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 3, 5, 7, 9, 10, 20};
        int left = 0;
        int right = nums.length - 1;

        int target = 14;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                System.out.printf(left + ":" + right);
                break;
            }

            if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
    }
}
