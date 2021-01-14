package com.arjun.learn.algorithms.graphs;

import java.util.*;

public class Traversal {
    public Map<Integer, ArrayList<Integer>> graph = new HashMap<>();

    public void addUndirectedEdge(Integer source, Integer destination) {
        this.graph.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
        this.graph.computeIfAbsent(destination, k -> new ArrayList<>()).add(source);
    }

    public void addDirectedEdge(Integer source, Integer destination) {
        this.graph.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
    }

    public Map<Integer, Integer> bfs(Integer startNode) {
        Map<Integer, Integer> parents = new HashMap<>();
        Map<Integer, Integer> level = new HashMap<>();

        if(!this.graph.containsKey(startNode)) {
            return parents;
        }


        Queue<Integer> store = new ArrayDeque<>();
        store.offer(startNode);
        level.put(startNode, 0);
        parents.put(startNode, Integer.MAX_VALUE);

        while(!store.isEmpty()) {
            Integer currentNode = store.poll();
            Integer currentLevel = level.get(currentNode);
            // System.out.println("Visiting " + currentNode + " Level " + currentLevel);

            this.graph.get(currentNode).forEach(edge -> {
                if(!parents.containsKey(edge)) {
                    store.offer(edge);
                    parents.put(edge, currentNode);
                    level.put(edge, currentLevel + 1);
                }
            });
        }

        return parents;
    }

    public Map<Integer, Integer> dfs() {
        Map<Integer, Integer> parents = new HashMap<>();

        for(Integer vertex : this.graph.keySet()) {
            if(!parents.containsKey(vertex)) {
                System.out.println("Visited " + vertex);
                parents.put(vertex, Integer.MAX_VALUE);
                dfsUtility(parents, vertex);
            }
        }
        // parents.getOrDefault()
        return parents;
    }

    public void dfsUtility(Map<Integer, Integer> parents, Integer vertex) {
        for(Integer neighbour : this.graph.get(vertex)) {
            if(!parents.containsKey(neighbour)) {
                System.out.println("Visited " + neighbour);
                parents.put(neighbour, vertex);
                dfsUtility(parents, vertex);
            }
        }
    }

    public void printPath(Integer source, Integer destination) {
        Map<Integer, Integer> parents = bfs(source);

        if(!parents.containsKey(destination)) {
            System.out.println("Disconnected graph. Destination not reachable from source");
        }

        Integer current = destination;
        while(!current.equals(Integer.MAX_VALUE)) {
            System.out.print(current + " ---> ");
            current = parents.get(current);
        }
    }
}
