package com.arjun.learn.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q212 {
    char[][] board;
    int rows;
    int columns;
    List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.rows = board.length;
        this.columns = board[0].length;

        TrieNode root = new TrieNode();
        for(String word: words) {
            TrieNode node = root, temp;
            for(char ch : word.toCharArray()) {
                temp = node.get(ch);
                if (temp == null) {
                    temp = new TrieNode();
                    node.set(ch, temp);
                }
                node = temp;
            }

            node.setWord(word);
        }

        for(int i = 0; i < this.rows; i++) {
            for(int j = 0; j < this.columns; j++) {
                solve(i, j, root);
            }
        }

        return this.result;
    }

    public void solve(int i, int j, TrieNode parent) {
        char ch = this.board[i][j];
        TrieNode node = parent.get(this.board[i][j]);

        if(node.word != null) {
            this.result.add(node.word);
            node.word = null;
        }

        this.board[i][j] = '#';
        int[] posX = {-1, 0, 1, 0};
        int[] posY = {0, -1, 0, 1};
        for(int d = 0; d < 4; d++) {
            int row = i + posY[d], col = j + posX[d];
            if(row < 0 || row >= this.rows || col < 0 || col >= this.columns)
                continue;
            if(node.get(this.board[row][col]) != null)
                solve(row, col, node);
        }
        this.board[i][j] = ch;

        boolean delete = true;
        for(TrieNode child : node.nodes)
            if (child != null) {
                delete = false;
                break;
            }
        if(delete)
            parent.set(ch, null);
    }

    public static class TrieNode {
        TrieNode[] nodes;
        String word;

        public TrieNode() {
            this.nodes = new TrieNode[26];
        }

        public TrieNode get(char ch) {
            return this.nodes[ch - 'a'];
        }

        public void set(char ch, TrieNode node) {
            this.nodes[ch - 'a'] = node;
        }

        public void setWord(String word) {
            this.word = word;
        }
    }
}
