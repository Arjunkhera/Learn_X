package com.arjun.learn.algorithms.dynamicprogramming;

public class KnapsackTwoD {
  int[] values;
  int[][] constraints;
  Integer n, MAX_WEIGHT, MAX_VOLUME;

  public KnapsackTwoD() {
    values = null;
    constraints = null;
    n = null;
  }

  public KnapsackTwoD(int[] values, int[][] constraints, Integer MAX_WEIGHT, Integer MAX_VOLUME) {
    this.values = values;
    this.constraints = constraints;
    this.n = values.length;
    this.MAX_WEIGHT = MAX_WEIGHT;
    this.MAX_VOLUME = MAX_VOLUME;
  }

  public int calculate() {
    int[][] dp = new int[MAX_WEIGHT + 1][MAX_VOLUME + 1];

    int[] state = new int[2];
    state[0] = MAX_WEIGHT;
    state[1] = MAX_VOLUME;

    return solve(state, dp);
  }

  private int solve(int[] state, int[][] dp) {
    // Check Constraints
    for (int j : state) {
      if (j <= 0) {
        return 0;
      }
    }

    // Already Visited
    if (dp[state[0]][state[1]] > 0) {
      return dp[state[0]][state[1]];
    }

    int current = 0;
    for (int i = 0; i < this.n; i++) {
      int j = 0;
      for (; j < state.length; j++) {
        if (state[j] < constraints[j][i]) {
          break;
        }
      }

      if (j == state.length) {
        for (int k = 0; k < state.length; k++) {
          state[k] -= constraints[k][i];
        }
        current = Math.max(current, solve(state, dp) + this.values[i]);
        // reset the state to original
        for (int k = 0; k < state.length; k++) {
          state[k] += constraints[k][i];
        }
      }
    }

    // Store and return
    dp[state[0]][state[1]] = current;
    return current;
  }
}
