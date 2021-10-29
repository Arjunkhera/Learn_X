package com.arjun.learn.algorithms.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Weighted implements Graph {
  public final Map<Integer, ArrayList<int[]>> list = new HashMap<>();

  public void addUndirectedEdge(Integer source, Integer destination, int weight) {
    this.list.computeIfAbsent(source, k -> new ArrayList<>()).add(new int[]{destination, weight});
    this.list.computeIfAbsent(destination, k -> new ArrayList<>()).add(new int[]{destination, weight});
  }

  public void addDirectedEdge(Integer source, Integer destination, int weight) {
    this.list.computeIfAbsent(source, k -> new ArrayList<>()).add(new int[]{destination, weight});
  }

  public void print() {
    for (Map.Entry<Integer, ArrayList<int[]>> entry : list.entrySet()) {
      System.out.printf("[%d] -> %s", entry.getKey(), entry.getValue());
    }
  }
}
