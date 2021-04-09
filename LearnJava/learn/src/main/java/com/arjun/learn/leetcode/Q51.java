package com.arjun.learn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q51 {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for(int i = 0; i < 3; i++) {
            Arrays.fill(board[i], '.');
        }

        List<String> current = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            current.add(new String(board[i]));
        }

        System.out.println(new String(board[0]));
        // System.out.println("Heleo");
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        // solve(result, new ArrayList<>(n));

        return result;
    }

}
