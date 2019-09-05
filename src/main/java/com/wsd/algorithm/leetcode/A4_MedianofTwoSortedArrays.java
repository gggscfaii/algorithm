package com.wsd.algorithm.leetcode;

/**
 * A4_MedianofTwoSortedArrays
 * 求两个有序数组中位数：
 * 1.合并两个数组，取中间一个数或两个数
 * 2.分治搜索算法
 *    len(left_part)=len(right_part)
 *    max(\text{left\_part}) \leq \min(\text{right\_part})max(left_part)≤min(right_part)
 *   ji+j=m−i+n−j (or: m - i + n - j + 1m−i+n−j+1
 *   B[j−1]≤A[i] and \text{A}[i-1] \leq \text{B}[j]A[i−1]≤B[j]
 * Created by sdwang on 2019/9/4 18:27.
 */
public class A4_MedianofTwoSortedArrays {

    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        if ((nums1 == null || nums1.length == 0) && (nums2 == null || nums2.length == 0)) {
            return 0;
        }

        int len1 = 0, len2 = 0;
        if (nums1 != null) len1 += nums1.length;
        if (nums2 != null) len2 += nums2.length;

        int[] nums = new int[len1 + len2];
        int i = 0, j = 0, k = 0;
        while (i < len1 && j < len2) {
            if (nums1[i] < nums2[j]) {
                nums[k] = nums1[i];
                i++;
            } else {
                nums[k] = nums2[j];
                j++;
            }
            k++;
        }

        while (i < len1) {
            nums[k++] = nums1[i++];
        }

        while (j < len2) {
            nums[k++] = nums2[j++];
        }

        int mid = (len1 + len2) / 2;
        if ((len1 + len2) % 2 == 0) {
            return (nums[mid - 1] + nums[mid]) / 2.0;
        } else {
            return nums[mid > 0 ? mid : 0];
        }
    }

    public static double findMedianSortedArrays2(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays1(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(findMedianSortedArrays1(new int[]{1, 3}, new int[]{2}));
        System.out.println(findMedianSortedArrays1(null, new int[]{1}));

        System.out.println(findMedianSortedArrays2(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(findMedianSortedArrays2(new int[]{1, 3}, new int[]{2}));

    }
}
