package com.wsd.algorithm.leetcode;

/**
 * Created by sdwang on 2020/2/15.
 */
public class A79_WordSearch {

    public static boolean exist(char[][] board, String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != word.charAt(0)) continue;

                if (exist(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean exist(char[][] board, int row, int col, int cnt, String word) {
        if (cnt == word.length()) {
            return true;
        }

        if (row < 0 || row == board.length || col < 0 || col == board[0].length) {
            return false;
        }

        if (board[row][col] != word.charAt(cnt)) {
            return false;
        }

        char c = board[row][col];
        board[row][col] = '#';
        if (exist(board, row - 1, col, cnt + 1, word)) {
            return true;
        }

        if (exist(board, row + 1, col, cnt + 1, word)) {
            return true;
        }

        if (exist(board, row, col + 1, cnt + 1, word)) {
            return true;
        }

        if (exist(board, row, col - 1, cnt + 1, word)) {
            return true;
        }

        board[row][col] = c;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(exist(
                new char[][]{
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                }, "ABCCED"));

        System.out.println(exist(
                new char[][]{
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                }, "SEE"));

        System.out.println(exist(
                new char[][]{
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                }, "ABCB"));

    }
}
