package com.arjun.learn.algorithms.graphs;

import java.util.Arrays;

public class ShortestPath {

  /**
   * Find shortest distance between source and destination
   */
  public static int bellmanFordDp(int n, int[][] edges, int src, int dst) {
    int[][] dp = new int[2][n];
    for (int i = 0; i < 2; i++) {
      Arrays.fill(dp[i], Integer.MAX_VALUE);
    }
    dp[0][src] = 0;

    for (int i = 1; i < n; i++) {
      dp[1][src] = 0;
      for (int[] edge : edges) {
        if (dp[0][edge[0]] < Integer.MAX_VALUE) {
          dp[1][edge[1]] = Math.min(dp[1][edge[1]], dp[0][edge[0]] + edge[2]);
        }
      }

      dp[0] = dp[1].clone();
    }

    // check for negative weight cycles
    // if you are able to relax once more, means you have a negative weight cycle
    dp[1][src] = 0;
    for (int[] edge : edges) {
      if (dp[0][edge[0]] < Integer.MAX_VALUE && dp[0][edge[0]] + edge[2] < dp[1][edge[1]]) {
        return -1;
      }
    }

    return dp[0][dst] == Integer.MAX_VALUE ? -1 : dp[0][dst];
  }

  /**
   * Find shortest distance between source and destination with edge length not more than k
   */
  public static int bellmanFordDpKEdges(int n, int[][] edges, int src, int dst, int k) {
    int[][] dp = new int[2][n];
    for (int i = 0; i < 2; i++) {
      Arrays.fill(dp[i], Integer.MAX_VALUE);
    }
    dp[0][src] = 0;
    k = Math.min(n - 1, k);

    for (int i = 1; i <= k; i++) {
      dp[1][src] = 0;
      for (int[] edge : edges) {
        if (dp[0][edge[0]] < Integer.MAX_VALUE) {
          dp[1][edge[1]] = Math.min(dp[1][edge[1]], dp[0][edge[0]] + edge[2]);
        }
      }

      dp[0] = dp[1].clone();
    }

    return dp[0][dst] == Integer.MAX_VALUE ? -1 : dp[0][dst];
  }

  public static int bellmanFordOptimized(int n, int[][] edges, int src, int dst) {
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;

    boolean isModified = true;
    int i;
    for (i = 1; i <= n && isModified; i++) {
      isModified = false;
      for (int[] edge : edges) {
        if (dist[edge[0]] < Integer.MAX_VALUE) {
          if(dist[edge[0]] + edge[2] < dist[edge[1]]) {
            isModified = true;
            dist[edge[1]] = dist[edge[0]] + edge[2];
          }
        }
      }
    }

    // condition for checking negative weight cycle
    if(isModified) return -1;

    return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
  }
}
