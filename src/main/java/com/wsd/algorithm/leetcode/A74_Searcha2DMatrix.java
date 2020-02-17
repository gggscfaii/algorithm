package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/2/14.
 */
public class A74_Searcha2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length <= 0 || matrix[0].length <= 0) return false;

        int rlow = 0, rhigh = matrix.length;
        while (rlow + 1 < rhigh) {
            int mid = (rlow + rhigh) / 2;
            if (target == matrix[mid][0]) {
                rlow = mid;
                break;
            } else if (matrix[mid][0] < target) {
                rlow = mid;
            } else {
                rhigh = mid;
            }
        }

        int clow = 0, chigh = matrix[rlow].length;
        while (clow + 1 < chigh) {
            int mid = (clow + chigh) / 2;
            if (target == matrix[rlow][mid]) {
                return true;
            } else if (matrix[rlow][mid] < target) {
                clow = mid;
            } else {
                chigh = mid;
            }
        }
        return target == matrix[rlow][clow];
    }

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1, 3, 5}}, 4));

        System.out.println(searchMatrix(
                new int[][]{{1, 3, 5, 7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 50}
                }, 3));

        System.out.println(searchMatrix(
                new int[][]{{1, 3, 5, 7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 50}
                }, 13));

        System.out.println(searchMatrix(new int[][]{{1}}, 1));
        System.out.println(searchMatrix(new int[][]{{1, 3}}, 3));
        System.out.println(searchMatrix(new int[][]{{1}, {3}}, 3));
    }
}
