package com.arjun.learn.introduction;

import java.util.List;

public class Main {

  public static void main(String[] args) {
    List<Integer> weights = List.of(5,10, 20, 30);
    List<Integer> values = List.of(160, 110, 150, 50);

    System.out.println(solve(weights, values, 20));
  }

  public static int solve(List<Integer> weights, List<Integer> values, int maxWeight) {
    int[][] dp = new int[weights.size() + 1][maxWeight + 1];

    for(int i = 1; i <= weights.size(); i++) {
      for(int j = 1; j <= maxWeight; j++) {
        dp[i][j] = dp[i - 1][j];
        if(j >= weights.get(i - 1))
          dp[i][j] = Math.max(dp[i - 1][j], dp[i-1][j - weights.get(i - 1)] + values.get(i - 1));
      }
    }

    return dp[weights.size()][maxWeight];
  }
}

