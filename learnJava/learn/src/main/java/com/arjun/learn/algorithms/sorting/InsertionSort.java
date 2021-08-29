package com.arjun.learn.algorithms.sorting;

public class InsertionSort {
  public static void sort(int[] input, int l, int r) {
    for(int i = l+1; i <=r; i++) {
      for(int j = i-1; j >= l && input[j] > input[j+1]; j--) {
        int temp = input[j];
        input[j] = input[j+1];
        input[j+1] = temp;
      }
    }
  }
}
