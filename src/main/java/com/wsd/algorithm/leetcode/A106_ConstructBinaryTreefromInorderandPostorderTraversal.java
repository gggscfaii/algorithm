package com.wsd.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sdwang on 2020/2/22.
 */
public class A106_ConstructBinaryTreefromInorderandPostorderTraversal {

    static Map<Integer, Integer> inOrderMap;

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return buildTree(0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public static TreeNode buildTree(int inStart, int inEnd,
                                     int[] postorder, int postStart, int postEnd) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }

        int rootVal = postorder[postEnd];
        int rootIndex = inOrderMap.get(rootVal);
        int leftLen = rootIndex - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(inStart, rootIndex - 1, postorder, postStart, postStart + leftLen - 1);
        root.right = buildTree(rootIndex + 1, inEnd, postorder, postStart + leftLen, postEnd - 1);
        return root;
    }

    public static void main(String[] args) {
        TreeNodeUtil.print(buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3}));
    }
}
