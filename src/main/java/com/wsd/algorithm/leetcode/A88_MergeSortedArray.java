package com.wsd.algorithm.leetcode;

/**
 * 从后往前填充，后续尝试
 * Created by sdwang on 2020/2/18.
 */
public class A88_MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = 0, j = 0;
        while (i < nums1.length && j < n) {
            if (i < m && nums1[i] <= nums2[j]) {
                i++;
            } else {
                int x = m;
                while (x > i) {
                    nums1[x--] = nums1[x];
                }
                m++;
                nums1[i++] = nums2[j++];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{-1, 0, 0, 3, 3, 3, 0, 0, 0};
        int[] nums2 = new int[]{1, 2, 2};

        merge(nums1, 6, nums2, 3);
        ArrayUtil.print(nums1);

    }

}
