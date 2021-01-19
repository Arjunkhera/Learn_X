package com.arjun.learn.algorithms.union;

public class UnionOneDWithoutRank {
    private final int[] parent;

    public UnionOneDWithoutRank(int capacity) {
        this.parent = new int[capacity];
        for(int i = 0; i < capacity; i++) this.parent[i] = i;
    }

    public int union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if(parentA != parentB) {
            parent[parentB] = parentA;
        }

        return parentA;
    }

    public int find(int node) {
        if(parent[node] == node) return node;
        // compress the path
        return parent[node] = find(parent[node]);
    }

    public int[] getParent() {
        return this.parent;
    }
}
