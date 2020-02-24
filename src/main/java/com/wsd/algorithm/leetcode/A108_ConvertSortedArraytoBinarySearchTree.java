package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/2/22.
 */
public class A108_ConvertSortedArraytoBinarySearchTree {

    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public static TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = end - (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, start, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        TreeNodeUtil.print(sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
    }
}
