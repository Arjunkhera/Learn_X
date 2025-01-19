package com.arjun.learn.algorithms.searching;

import org.junit.jupiter.api.Test;

public class BinarySearchTest {

    int[] arr = new int[]{1,1,1,2,2,3,4,5,5,7,7,8,10,12,19,24};
    int n = arr.length;
    BinarySearch binarySearch = new BinarySearch(this.arr);

    @Test
    public void containsTrue() {
        // single element
        assert 5 == binarySearch.contains(0, n-1, 3);

        // duplicate element
        assert 7 == binarySearch.contains(0, n-1, 5);

        // missing element between smallest and largest
        assert -1 == binarySearch.contains(0, n-1, 11);

        // missing element smaller than smallest
        assert -1 == binarySearch.contains(0, n-1, -5);

        // missing element larger than largest
        assert -1 == binarySearch.contains(0, n-1, 27);
    }

    @Test
    public void nextLargest() {
        // single element
        assert 6 == binarySearch.findNextLargest(0, n-1, 3);

        // duplicate element
        assert 9 == binarySearch.findNextLargest(0, n-1, 5);

        // missing element between smallest and largest
        assert 13 == binarySearch.findNextLargest(0, n-1, 11);

        // missing element smaller than smallest
        assert 0 == binarySearch.findNextLargest(0, n-1, -5);

        // missing element larger than largest
        assert n == binarySearch.findNextLargest(0, n-1, 27);
    }

    @Test
    public void nextSmallest() {
        // single element
        assert 4 == binarySearch.findNextSmallest(0, n-1, 3);

        // duplicate element
        assert 6 == binarySearch.findNextSmallest(0, n-1, 5);

        // missing element between smallest and largest
        assert 12 == binarySearch.findNextSmallest(0, n-1, 11);

        // missing element smaller than smallest
        assert -1 == binarySearch.findNextSmallest(0, n-1, -5);

        // missing element larger than largest
        assert n-1 == binarySearch.findNextSmallest(0, n-1, 27);
    }
}
