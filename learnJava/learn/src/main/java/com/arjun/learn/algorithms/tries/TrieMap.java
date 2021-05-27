package com.arjun.learn.algorithms.tries;

import java.util.HashMap;
import java.util.Map;

public class TrieMap {

    boolean isWord;
    String word;
    Map<Integer, TrieMap> pointer;

    public void Trie() {
        isWord = false;
        word = null;
        pointer = new HashMap<>();
    }

    public void add(String word) {
        TrieMap node = this;
        for(char ch : word.toCharArray()) {
            node = node.pointer.computeIfAbsent(ch - 97, k -> new TrieMap());
        }

        node.isWord = true;
        node.word = word;
    }
}
