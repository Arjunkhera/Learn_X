package com.arjun.learn;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {

  class Pair {

    int a;
    int b;

    Pair(int a, int b) {
      this.a = a;
      this.b = b;
    }

  }

  class The_Comparator implements Comparator<Pair> {
    public int compare(Pair p1, Pair p2) {
      return p2.b - p1.b;
    }
  }

  public int maxCompatibilitySum(int[][] students, int[][] mentors) {
    int[] arr = new int[students.length];
    HashMap<Integer, PriorityQueue<Pair>> h = new HashMap<>();
    HashMap<Integer, Integer> blacklist = new HashMap<>();

    for (int i = 0; i < students.length; i++) {
      int[] s1 = students[i];
      for (int j = 0; j < mentors.length; j++) {
        int[] m1 = mentors[i];

        int sum = 0;
        for (int k = 0; k < s1.length; k++) {
          if (s1[k] == m1[k]) {
            sum++;
          }
        }

        PriorityQueue<Pair> list = h.getOrDefault(i, new PriorityQueue<>());
        list.add(new Pair(j, sum));
        h.put(i, list);
      }
    }

    int res = 0;
    while (true) {
      boolean check = false;
      for (int i = 0; i < students.length; i++) {
        PriorityQueue<Pair> p = h.get(students[i]);

        while (p.size() > 1 && blacklist.containsKey(p.peek().a)) {
          p.remove();
        }

        if (p.size() == 1) {
          if (blacklist.containsKey(p.peek().a) && blacklist.get(p.peek().a) != i) {
            p.remove();
          } else {
            blacklist.put(p.peek().a, i);
          }
        }

        if (p.size() == 1) {
          check = true;
        }

        h.put(i, p);
      }

      if (!check) {
        break;
      }

    }

    for (Map.Entry<Integer, PriorityQueue<Pair>> e : h.entrySet()) {
      PriorityQueue<Pair> p = e.getValue();
      res = res + ((p.size() == 0) ? 0 : p.peek().b);
    }
    return res;

  }
}
