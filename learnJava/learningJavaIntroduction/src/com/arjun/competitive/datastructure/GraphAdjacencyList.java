package com.arjun.competitive.datastructure;

import java.util.ArrayList;

public class GraphAdjacencyList {
    ArrayList<ArrayList<Integer>> graph;

    public void Graph() {
        graph = new ArrayList<>();
    }

    public void addEdge(Integer source, Integer destination) {
        this.graph.get(source).add(destination);
    }
}
