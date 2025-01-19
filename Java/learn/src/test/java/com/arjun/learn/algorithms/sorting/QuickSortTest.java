package com.arjun.learn.algorithms.sorting;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class QuickSortTest {
  @Test
  public void testEven() {
    int[] arr = new int[]{4,5,2,2,1,8,9,10};
    QuickSort.sort(arr, 0, arr.length-1);
    assert Arrays.equals(arr, new int[]{1, 2, 2, 4, 5, 8, 9, 10});
  }

  @Test
  public void testOdd() {
    int[] arr = new int[]{4,5,2,2,1,8,9,10,13};
    QuickSort.sort(arr, 0, arr.length-1);
    assert Arrays.equals(arr, new int[]{1, 2, 2, 4, 5, 8, 9, 10, 13});
  }
}
