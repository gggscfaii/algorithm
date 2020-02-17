package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/2/14.
 */
public class A73_SetMatrixZeroes {

    public static void setZeroes(int[][] matrix) {

        boolean brow = false, bcol = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) brow = true;
                    if (j == 0) bcol = true;

                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (brow) for (int i = 0; i < matrix[0].length; i++) matrix[0][i] = 0;
        if (bcol) for (int i = 0; i < matrix.length; i++) matrix[i][0] = 0;
    }

    public static void main(String[] args) {
        setZeroes(new int[][]{{1, 0, 3}});
    }
}
