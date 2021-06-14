package com.arjun.learn.algorithms.searching;

public class BinarySearch {
    int[] arr;

    public BinarySearch(int[] input) {
        this.arr = input;
    }

    public void setArr(int[] newArr) {
        this.arr = newArr;
    }

    /**
     * Return if target is present in the array
     * No promise of what index will be returned
     * if duplicates are present
     * @param low
     * @param high
     * @param target
     * @return
     */
    public int contains(int low, int high, int target) {
        int mid;

        while(low <= high) {
            mid = low + (high - low)/2;

            if(this.arr[mid] == target)
                return mid;
            if(this.arr[mid] < target)
                low = mid+1;
            else
                high = mid-1;
        }

        return -1;
    }

    /**
     * Return index of next largest element
     * For target greater or equal to largest element return n for out of bounds
     * For target smaller than smallest element return first element
     *
     * @param low
     * @param high
     * @param target
     * @return
     */
    public int findNextLargest(int low, int high, int target) {
        int mid;

        while(low <= high) {
            mid = low + (high - low)/2;

            if(this.arr[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return low;
    }

    /**
     * Return index of next smallest element
     * For target smaller or equal to smallest element return -1 for out of bounds
     * For target greater than largest element return last element
     * @param low
     * @param high
     * @param target
     * @return
     */
    public int findNextSmallest(int low, int high, int target) {
        int mid;

        while(low <= high) {
            mid = low + (high - low)/2;

            if(this.arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return high;
    }
}
