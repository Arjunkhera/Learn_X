package com.arjun.learn.algorithms.searching;

import org.junit.Test;

public class BinarySearchTest {

    int[] arr = new int[]{1,1,1,2,2,3,4,5,5,7,7,8,10,12,19,24};
    int n = arr.length;
    BinarySearch binarySearch = new BinarySearch(this.arr);

    @Test
    public void containsTrue() {
        // single element
        assert 5 == binarySearch.contains(0, n, 3);

        // duplicate element
        assert 8 == binarySearch.contains(0, n, 5);

        // missing element
        assert -1 == binarySearch.contains(0, n, 15);
    }
}
