package com.wsd.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sdwang on 2020/2/8.
 */
public class A51_NQueen {

    public static List<List<String>> solveNQueens(int n) {

        List<List<String>> solves = new ArrayList<>();
        int pos[][];
        for (int i = 0; i < n; i++) {
            pos = new int[n][n];
            pos[0][i] = 1;
            solve(solves, pos, 1, n);
        }
        return solves;
    }

    private static List<String> getSolve(int[][] pos) {
        List<String> queens = new ArrayList<>();
        for (int row = 0; row < pos.length; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < pos.length; col++) {
                sb.append(pos[row][col] == 1 ? 'Q' : '.');
            }
            queens.add(sb.toString());
        }
        return queens;
    }

    public static void solve(List<List<String>> solves, int pos[][], int start, int n) {
        if (start >= n) {
            solves.add(getSolve(pos));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (colHasQueen(pos, start, i)) {
                continue;
            }

            if (slideHasQueen(pos, start, i, n)) {
                continue;
            }

            pos[start][i] = 1;
            solve(solves, pos, start + 1, n);
            pos[start][i] = 0;
        }
    }

    private static boolean slideHasQueen(int[][] pos, int row, int col, int n) {
        for (int r = 0; r < row; r++) {
            if (col - row + r >= 0 && pos[r][col - row + r] == 1) {
                return true;
            }

            if (col + row - r < n && pos[r][col + row - r] == 1) {
                return true;
            }
        }
        return false;
    }

    private static boolean colHasQueen(int[][] pos, int row, int col) {
        for (int r = 0; r < row; r++) {
            if (pos[r][col] == 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}
