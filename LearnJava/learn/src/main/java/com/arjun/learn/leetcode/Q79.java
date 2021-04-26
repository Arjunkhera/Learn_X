package com.arjun.learn.leetcode;

public class Q79 {
    char[][] board;
    int r, c;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.r = board.length;
        this.c = board[0].length;

        for(int i = 0; i < this.r; i++) {
            for(int j = 0; j < this.c; j++) {
                if(solve(i, j, 0, word))
                    return true;
            }
        }
        return false;
    }

    public boolean solve(int i, int j, int index, String word) {
        if(index == word.length()) {
            return true;
        }

        if(i < 0 || i >= this.r || j < 0 || j >= this.c)
            return false;
        if(board[i][j] != word.charAt(index))
            return false;

        this.board[i][j] = '#';
        int[] moveX = {-1, 0, 1, 0};
        int[] moveY = {0, -1, 0, 1};
        for(int k = 0; k < 4; k++) {
            if(solve(i + moveY[k], j + moveX[k], index + 1, word))
                return true;
        }

        this.board[i][j] = word.charAt(index);
        return false;
    }
}
