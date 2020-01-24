package com.wsd.algorithm.leetcode;

import static com.wsd.algorithm.leetcode.A36_ValidSudoku.isValidSudoku;

/**
 * A37_SudokuSolver
 * Created by sdwang on 2020/1/22 19:17.
 */
public class A37_SudokuSolver {

    private static boolean solve = false;

    public static boolean solveSudoku(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') continue;

                for (int c = 1; c < 10; c++) {
                    board[i][j] = (char) (48 + c);
                    if (isValidSudoku(board)) {
                        if (solveSudoku(board)) {
                            return true;
                        }
                    }
                    board[i][j] = '.';
                }

                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String s = "5,3,.,.,7,.,.,.,.,6,.,.,1,9,5,.,.,.,.,9,8,.,.,.,.,6,.,8,.,.,.,6,.,.,.,3,4,.,.,8,.,3,.,.,1,7,.,.,.,2,.,.,.,6,.,6,.,.,.,.,2,8,.,.,.,.,4,1,9,.,.,5,.,.,.,.,8,.,.,7,9";
        String[] chars = s.split(",");

        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = chars[i * 9 + j].charAt(0);
            }
        }

        solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}
