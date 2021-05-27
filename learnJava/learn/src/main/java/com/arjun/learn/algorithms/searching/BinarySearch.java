package com.arjun.learn.algorithms.searching;

public class BinarySearch {
    int[] arr;

    public BinarySearch(int[] input) {
        this.arr = input;
    }

    public void setArr(int[] newArr) {
        this.arr = newArr;
    }

    public int contains(int low, int high, int target) {
        int mid = low + (high - low)/2;

        while(low <= high) {
            if(this.arr[mid] == target)
                return mid;
            if(this.arr[mid] < target)
                low = mid+1;
            else
                high = mid-1;

            mid = low + (high - low)/2;
        }

        return -1;
    }
}
