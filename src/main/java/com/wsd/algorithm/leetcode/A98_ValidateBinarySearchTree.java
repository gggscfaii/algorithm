package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/2/21.
 */
public class A98_ValidateBinarySearchTree {

//    public static TreeNode last = null;
//    public static boolean isValidBST(TreeNode root)
//    {
//        if(root == null)
//            return true;
//        else
//        {
//            boolean leftRes = isValidBST(root.left);
//            //short cut
//            if(!leftRes)
//                return false;
//            if(last!=null && last.val >= root.val)
//                return false;
//            last = root;
//            return isValidBST(root.right);
//        }
//    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left != null && root.val <= root.left.val) {
            return false;
        }

        if (root.right != null && root.val >= root.right.val) {
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }

}
