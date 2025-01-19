package com.arjun.learn.leetcode;

public class Q208 {
    class Trie {
        private Node root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new Node(26);
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Node node = this.root, temp;
            for(char ch : word.toCharArray()) {
                temp = node.get(ch);
                if(temp != null) {
                    node = temp;
                } else {
                    temp = new Node(26);
                    node.set(ch, temp);
                    node = temp;
                }
            }

            node.setPresent();
        }

        /** Returns if the word is in the trie. */
        public Node searchPrefix(String word) {
            Node node = this.root;
            for(char ch : word.toCharArray()) {
                node = node.get(ch);
                if(node == null)
                    break;
            }

            return node;
        }

        public boolean search(String word) {
            Node node = this.searchPrefix(word);
            return node != null && node.isPresent();
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Node node = this.searchPrefix(prefix);
            return node != null;
        }

        public class Node {
            boolean present;
            Node[] array;
            int size;

            public Node() {

            }

            public Node(int size) {
                this.size = size;
                this.array = new Node[this.size];
                this.present = false;
            }

            public void set(char ch, Node node) {
                this.array[ch - 'a'] = node;
            }

            public Node get(char ch) {
                return this.array[ch - 'a'];
            }

            public boolean isPresent() {
                return present;
            }

            public void setPresent() {
                this.present = true;
            }
        }
    }
}
