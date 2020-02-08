package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/1/30.
 */
public class A48_RotateImage {

    public static void rotate(int[][] matrix) {

        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            int low = i, high = n - i - 1;
            for (int j = low; j < high; j++) {
                int tmp;
                tmp = matrix[i][j];
                // left to top
                matrix[i][j] = matrix[n - j - 1][i];
                // bottom to left
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                // right to bottom
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                // top to right
                matrix[j][n - i - 1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotate(matrix);

        ArrayUtil.print(matrix);

        int[][] matrix1 = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}

        };
        rotate(matrix1);

        ArrayUtil.print(matrix1);

    }
}
