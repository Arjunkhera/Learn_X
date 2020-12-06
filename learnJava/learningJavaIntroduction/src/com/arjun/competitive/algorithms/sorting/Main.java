package com.arjun.competitive.algorithms.sorting;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // Generate array with random elements
        int[] arr = new int[10];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        Arrays.stream(arr)
                .forEach(element -> System.out.print(element + " "));
        System.out.println("\n----\n");

        Sort sort = new BubbleSort();
        sort.sortArray(arr);
        Arrays.stream(arr)
                .forEach(element -> System.out.print(element + " "));
    }
}
