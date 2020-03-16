package com.wsd.algorithm.leetcode;

/**
 * A130_SurroundedRegions
 * Created by sdwang on 2020/3/16 9:57.
 */
public class A130_SurroundedRegions {

    public static void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }

        for (int i = 0; i < board.length; i++) {
            trace(board, i, 0);
            trace(board, i, board[0].length - 1);
        }

        for (int i = 0; i < board[0].length; i++) {
            trace(board, 0, i);
            trace(board, board.length - 1, i);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

                if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }

    }


    public static void trace(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }

        if (board[i][j] == 'X' || board[i][j] == '1') {
            return;
        }

        board[i][j] = '1';
        trace(board, i + 1, j);
        trace(board, i, j + 1);
        trace(board, i - 1, j);
        trace(board, i, j - 1);
    }


    public static void main(String[] args) {
//        char[][] board = new char[][]{
//                {'X', 'X', 'X', 'X'},
//                {'X', 'O', 'O', 'X'},
//                {'X', 'X', 'O', 'X'},
//                {'X', 'O', 'X', 'X'}
//        };

        char[][] board = new char[][]{
                {'O', 'O'},
                {'O', 'O'}
        };

//        char[][] board = new char[][]{
//                {'O','X','O'},
//                {'X','O','X'},
//                {'O','X','O'}
//        };

//        char[][] board = new char[][]{
//                {'X', 'O', 'X', 'O', 'O', 'O', 'O'},
//                {'X', 'O', 'O', 'O', 'O', 'O', 'O'},
//                {'X', 'O', 'O', 'O', 'O', 'X', 'O'},
//                {'O', 'O', 'O', 'O', 'X', 'O', 'X'},
//                {'O', 'X', 'O', 'O', 'O', 'O', 'O'},
//                {'O', 'O', 'O', 'O', 'O', 'O', 'O'},
//                {'O', 'X', 'O', 'O', 'O', 'O', 'O'}};

//        char[][] board = new char[][]{
//                {'X', 'O', 'X', 'O', 'X', 'O', 'O', 'O', 'X', 'O'},
//                {'X', 'O', 'O', 'X', 'X', 'X', 'O', 'O', 'O', 'X'},
//                {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'X'},
//                {'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X'},
//                {'O', 'O', 'X', 'X', 'O', 'X', 'X', 'O', 'O', 'O'},
//                {'X', 'O', 'O', 'X', 'X', 'X', 'O', 'X', 'X', 'O'},
//                {'X', 'O', 'X', 'O', 'O', 'X', 'X', 'O', 'X', 'O'},
//                {'X', 'X', 'O', 'X', 'X', 'O', 'X', 'O', 'O', 'X'},
//                {'O', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'O'},
//                {'X', 'X', 'O', 'X', 'X', 'X', 'X', 'O', 'O', 'O'}};


//        char[][] board = new char[][]{
//                {'O', 'X', 'X', 'X', 'X', 'X', 'O', 'O'},
//                {'O', 'O', 'O', 'X', 'X', 'X', 'X', 'O'},
//                {'X', 'X', 'X', 'X', 'O', 'O', 'O', 'O'},
//                {'X', 'O', 'X', 'O', 'O', 'X', 'X', 'X'},
//                {'O', 'X', 'O', 'X', 'X', 'X', 'O', 'O'},
//                {'O', 'X', 'X', 'O', 'O', 'X', 'X', 'O'},
//                {'O', 'X', 'O', 'X', 'X', 'X', 'O', 'O'},
//                {'O', 'X', 'X', 'X', 'X', 'O', 'X', 'X'}};

        solve(board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + ",");
            }
            System.out.println();
        }

    }
}
