package com.wsd.algorithm.leetcode;

/**
 * A36_ValidSudoku
 * Created by sdwang on 2020/1/22 18:17.
 */
public class A36_ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {

        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] sub = new boolean[9][9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (c == '.') continue;

                int pos = c - '0' - 1;
                if (row[i][pos]) {
                    return false;
                }

                if (col[j][pos]) {
                    return false;
                }

                int idx = (i / 3) * 3 + j / 3;
                if (sub[idx][pos]) {
                    return false;
                }

                row[i][pos] = true;
                col[j][pos] = true;
                sub[idx][pos] = true;
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
        System.out.println(isValidSudoku(board));
    }

}
