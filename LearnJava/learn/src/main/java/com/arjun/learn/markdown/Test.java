package com.arjun.learn.markdown;

import java.util.*;

public class Test {
    public static void main(String[] args) {
    }

    Map<Integer, List<Integer>> graph = new HashMap();

    public int countComponents(int n, int[][] edges) {
        int result = 0;
        int sz = edges.length;
        if(sz == 0) return result;

        for(int i = 0; i < sz; i++) {
            graph.computeIfAbsent(edges[i][0], k -> new ArrayList<>()).add(edges[i][1]);
            graph.computeIfAbsent(edges[i][1], k -> new ArrayList<>()).add(edges[i][0]);
        }

        boolean[] visited = new boolean[graph.size()+1];
        for(Integer node : graph.keySet()) {
            if(!visited[node]) {
                result++;
                dfs(node, visited);
            }
        }
        return result;
    }

    public void dfs(int node, boolean[] visited) {
        visited[node] = true;
        for(int neighbor : graph.get(node)) {
            if(!visited[neighbor]) dfs(neighbor, visited);
        }
    }

}
