package com.arjun.learn.algorithms.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Unweighted implements Graph {

  public final Map<Integer, ArrayList<Integer>> list = new HashMap<>();

  public void addUndirectedEdge(Integer source, Integer destination) {
    this.list.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
    this.list.computeIfAbsent(destination, k -> new ArrayList<>()).add(source);
  }

  public void addDirectedEdge(Integer source, Integer destination) {
    this.list.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
  }

  public void print() {
    for (Map.Entry<Integer, ArrayList<Integer>> entry : list.entrySet()) {
      System.out.printf("[%d] -> %s", entry.getKey(), entry.getValue());
    }
  }
}
