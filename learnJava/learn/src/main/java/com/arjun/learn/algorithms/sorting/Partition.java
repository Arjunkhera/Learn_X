package com.arjun.learn.algorithms.sorting;

public class Partition {

    public static int partition(int[] input, int start, int end, int pivot) {
        if(pivot < start || pivot > end)
            return -1;

        swap(input, start, pivot);
        int i = start;
        for(int j = start+1; j <= end; j++)
            if(input[j] <= input[start])
                swap(input, ++i, j);

        swap(input, start, i);
        return i;
    }

    public static void swap(int[] input, int x, int y) {
        int temp = input[x];
        input[x] = input[y];
        input[y] = temp;
    }

    /**
     * Keep partitioning until returned index is equal to target index
     * For an unsorted we ensure that all elements to left of index are smaller
     * and elements to the right of index are greater
     */
    public static void semiSort(int[] input, int start, int end, int targetIndex) {
        int index = start;
        while(index != targetIndex) {
            index = Partition.partition(input, start, end, start);
            if(index == targetIndex)
                return;
            if(index < targetIndex) {
                start = index + 1;
            } else {
                end = index - 1;
            }
        }
    }
}
