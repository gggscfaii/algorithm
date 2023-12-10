package com.wsd.algorithm.leetcode.interview;

import com.wsd.algorithm.leetcode.ArrayUtil;

public class A88合并两个有序数组 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        if (m + n <= 0) {
            return;
        }

        int i = 0;
        int j = 0;
        int k = 0;
        int num[] = new int[m + n];
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                num[k] = nums1[i];
                i++;
            } else {
                num[k] = nums2[j];
                j++;
            }
            k++;
        }

        while (i < m) {
            num[k] = nums1[i];
            i++;
            k++;
        }

        while (j < n) {
            num[k] = nums2[j];
            j++;
            k++;
        }

        for (i = 0; i < m + n; i++) {
            nums1[i] = num[i];
        }
    }

    public static void main(String[] args) {
        int[] num1 = {4, 5, 6, 0, 0, 0};
        merge(num1, 3, new int[]{1, 2, 3}, 3);
        ArrayUtil.print(num1);
    }
}
