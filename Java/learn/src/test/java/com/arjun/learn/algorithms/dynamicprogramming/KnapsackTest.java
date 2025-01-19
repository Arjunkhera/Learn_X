package com.arjun.learn.algorithms.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class KnapsackTest {

  @Test
  public void knapsackTwoDTest() {
    int[] values = new int[]{900, 650, 5000, 950, 95};
    int[] weights = new int[]{240, 135, 2800, 410, 182};
    int[] volumes = new int[]{400, 400, 1500, 410, 190};

    int[][] constraints = new int[2][];
    constraints[0] = weights;
    constraints[1] = volumes;

    int MAX_WEIGHT = 9500;
    int MAX_VOLUME = 5500;

    KnapsackTwoD knapsackTwoD = new KnapsackTwoD(values, constraints, MAX_WEIGHT, MAX_VOLUME);
    int answer = knapsackTwoD.calculate();
    assertEquals(answer, 16945);
  }
}
