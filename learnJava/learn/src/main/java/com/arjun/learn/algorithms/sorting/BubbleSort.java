package com.arjun.learn.algorithms.sorting;

public class BubbleSort {
 public static void sort(int[] input, int l, int r) {
   for(int i = 0; i <= r-l; i++) {
    int j = l;
    for(; j < r - i - 1; j++) {
      if(input[j] > input[j+1]) {
        int temp = input[j];
        input[j] = input[j+1];
        input[j+1] = temp;
      }
    }
   }
 }
}
