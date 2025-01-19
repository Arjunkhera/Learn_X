package com.arjun.learn.algorithms.sorting;

public class SelectionSort {
  public static void sort(int[] input, int l, int r) {
    int val, idx;
    for(int i = l-1; i < r;) {
      val = Integer.MAX_VALUE;
      idx = i+1;
      for(int j = i+1; j <= r; j++)
        if(input[j] < val) {
          val = input[j];
          idx = j;
        }
      input[idx] = input[++i];
      input[i] = val;
    }
  }
}
