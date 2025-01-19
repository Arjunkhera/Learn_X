package com.arjun.learn.algorithms.union;

public class UnionOneD {
    private final int[] parent;

    public UnionOneD(int capacity) {
        this.parent = new int[capacity];

        for(int i = 0; i < capacity; i++) this.parent[i] = -1;
    }

    public int union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        // nodes are in same set
        if(parentA == parentB) return parentA;

        // merge according to ranks
        int rankA = parent[parentA];
        int rankB = parent[parentB];
        if(rankA <= rankB) {
            parent[parentA] = rankA + rankB;
            parent[parentB] = parentA;
            return parentA;
        } else {
            parent[parentB] = rankA + rankB;
            parent[parentA] = parentB;
            return parentB;
        }
    }

    public int find(int node) {
        if(parent[node] < 0) return node;
        // compress the path
        return parent[node] = find(parent[node]);
    }

    public int[] getParent() {
        return this.parent;
    }
}
