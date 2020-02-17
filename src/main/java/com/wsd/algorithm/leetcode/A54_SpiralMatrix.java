package com.wsd.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sdwang on 2020/2/8.
 */
public class A54_SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> nums = new ArrayList<>();
        int col = matrix[0].length;
        int row = matrix.length;

        for (int r = 0, c = 0; r < (row + 1) / 2 && c < (col + 1) / 2; r++, c++) {
            // top
            for (int i = c; i < col - c; i++) {
                nums.add(matrix[r][i]);
            }

            // right
            for (int i = r + 1; i < row - r; i++) {
                nums.add(matrix[i][col - c - 1]);
            }

            // bottom
            for (int i = col - c - 2; row - r - 1 > r && i >= c; i--) {
                nums.add(matrix[row - r - 1][i]);
            }

            // left
            for (int i = row - r - 2; col - c - 1 > c && i > r; i--) {
                nums.add(matrix[i][c]);
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> nums = spiralOrder(matrix);
        System.out.println(nums);

        matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        nums = spiralOrder(matrix);
        System.out.println(nums);

    }
}
