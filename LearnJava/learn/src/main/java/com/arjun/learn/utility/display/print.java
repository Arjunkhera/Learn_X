package com.arjun.utility.display;

public class print {
    public static void printArray(int[] arr) {
        for(int i = 0; i < arr.length-1; i ++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println(arr[arr.length-1]);
    }
}
