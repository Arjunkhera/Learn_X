package com.arjun.learn.algorithms.graphs;

import java.util.*;

public class TraversalString {
    public Map<String, ArrayList<String>> graph = new HashMap<>();

    public void addDirectedEdge(String source, String destination) {
        this.graph.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
    }

    public List<String> dfs(String start) {
        Set<String> visited = new HashSet<>();
        List<String> reachable = new ArrayList<>();

        dfsUtility(start, visited, reachable);
        return reachable;
    }

    public void dfsUtility(String current, Set<String> visited, List<String> reachable) {
        if(visited.contains(current))
            return;

        reachable.add(current);
        visited.add(current);
        for(String neighbour : this.graph.getOrDefault(current, new ArrayList<>()))
            dfsUtility(neighbour, visited, reachable);
    }

//    public void printPath(Integer source, Integer destination) {
//        Map<Integer, Integer> parents = dfs(source);
//
//        if(!parents.containsKey(destination)) {
//            System.out.println("Disconnected graph. Destination not reachable from source");
//        }
//
//        Integer current = destination;
//        while(!current.equals(Integer.MAX_VALUE)) {
//            System.out.print(current + " ---> ");
//            current = parents.get(current);
//        }
//    }

}
