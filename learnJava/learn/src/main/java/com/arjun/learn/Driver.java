package com.arjun.learn;

import java.util.Arrays;

public class Driver {
  public static void main(String[] args) {
    Union union = new Union(6);
    union.combine(0, 1);
    union.combine(2,3);
    union.combine(4,5);

    System.out.println(union.find(3));
    System.out.println(union.find(4));
  }
}

class Union {
    int[] parents;

    public Union(int size) {
      this.parents = new int[size];
      Arrays.fill(this.parents, -1);
    }

    public void combine(int a, int b) {
      int pa = find(a);
      int pb = find(b);

      if(this.parents[pa] <= this.parents[pb]) {
        this.parents[pa] += this.parents[pb];
        this.parents[pb] = pa;
      } else {
        this.parents[pb] += this.parents[pa];
        this.parents[pa] = pb;
      }
    }

    public int find(int node) {
      if(this.parents[node] < 0) return node;
      return this.parents[node] = find(this.parents[node]);
    }
}

