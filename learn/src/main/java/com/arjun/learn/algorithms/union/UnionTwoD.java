package com.arjun.learn.algorithms.union;

import java.util.Arrays;

public class UnionTwoD {
    int[] parent;

    public UnionTwoD(int rn, int cn) {
        parent = new int[rn*cn];
        Arrays.fill(parent, -1);
    }

    public void merge(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if(parentA == parentB) return;

        int rankA = parent[parentA];
        int rankB = parent[parentB];
        if(rankA > rankB) {
            parent[parentB] += rankA;
            parent[parentA] = parentB;
        } else {
            parent[parentA] += rankB;
            parent[parentB] = parentA;
        }
    }

    public int find(int node) {
        if(parent[node] < 0) return node;
        return parent[node] = find(parent[node]);
    }
}
