package com.arjun.learn;

public class App {

    public static void main(String[] args ) {

    }

    public static int gcd(int a, int b) {
        if(b == 0)
            return a;
        return gcd(b, a%b);
    }

    public static void insertionSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int j = i-1;
            while(j >= 0 && arr[j] > arr[j+1]) {
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
                j--;
            }
        }
    }
}
