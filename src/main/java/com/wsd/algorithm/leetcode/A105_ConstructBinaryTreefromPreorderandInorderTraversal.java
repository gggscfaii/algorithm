package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/2/22.
 */
public class A105_ConstructBinaryTreefromPreorderandInorderTraversal {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public static TreeNode buildTree(int[] preOrder, int preStart, int preEnd,
                                     int[] inorder, int inStart, int inEnd) {

        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int rootVal = preOrder[preStart];
        int i = inStart;
        while (i <= inEnd) {
            if (inorder[i] == rootVal) {
                break;
            }
            i++;
        }

        int len = i - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(preOrder, preStart + 1, preStart + len, inorder, inStart, i - 1);
        root.right = buildTree(preOrder, preStart + len + 1, preEnd, inorder, i + 1, inEnd);
        return root;
    }

    public static void main(String[] args) {
        TreeNodeUtil.print(buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }
}
