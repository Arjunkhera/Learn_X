package com.arjun.learn.algorithms.sorting;

public class QuickSort {
  public static void sort(int[] input, int l, int r) {
    if(l >= r) return;
    int index = Partition.partition(input, l, r, l);
    sort(input, l, index-1);
    sort(input, index+1, r);
  }
}
