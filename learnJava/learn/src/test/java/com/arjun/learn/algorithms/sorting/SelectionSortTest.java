package com.arjun.learn.algorithms.sorting;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class SelectionSortTest {

  @Test
  public void test() {
    int[] arr = new int[]{4,5,2,2,1,8,9,10};
    SelectionSort.sort(arr, 0, arr.length-1);
    assert Arrays.equals(arr, new int[]{1, 2, 2, 4, 5, 8, 9, 10});
  }
}
