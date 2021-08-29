package com.arjun.learn.algorithms.sorting;

public class MergeSort {
  public static void sort(int[] input, int l, int r) {
    int[] res = mergeSort(input, l, r);
    for(int i = l; i <= r; i++)
      input[i] = res[i];
  }

  private static int[] mergeSort(int[] input, int l, int r) {
    if(l == r) return new int[]{input[l]};

    int mid = l + (r - l)/2, k, i, j;
    int[] left = mergeSort(input, l, mid);
    int[] right = mergeSort(input, mid+1, r);

    int[] res = new int[r - l + 1];
    for(k = 0, i = 0, j = 0; i < left.length || j < right.length; k++) {
      if(i < left.length && j < right.length) {
        res[k] = left[i] <= right[j] ? left[i++] : right[j++];
      } else if(i < left.length) {
        res[k] = left[i++];
      } else {
        res[k] = right[j++];
      }
    }
    return res;
  }
}
