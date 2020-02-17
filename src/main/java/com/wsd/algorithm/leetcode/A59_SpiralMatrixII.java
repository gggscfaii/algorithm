package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/2/10.
 */
public class A59_SpiralMatrixII {

    public static int[][] generateMatrix(int n) {

        int matrix[][] = new int[n][n];
        int num = 1;
        for (int i = 0; i < (n + 1) / 2; i++) {
            // top
            for (int j = i; j < n - i; j++) {
                matrix[i][j] = num++;
            }

            // right
            for (int j = i + 1; j < n - i; j++) {
                matrix[j][n - i - 1] = num++;
            }

            // bottom
            for (int j = n - i - 2; j >= i; j--) {
                matrix[n - i - 1][j] = num++;
            }

            // left
            for (int j = n - i - 2; j >= i + 1; j--) {
                matrix[j][i] = num++;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        ArrayUtil.print(generateMatrix(3));

        System.out.println();
        ArrayUtil.print(generateMatrix(4));

    }

}
