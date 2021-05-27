package com.arjun.learn;


import com.arjun.learn.algorithms.dynamicprogramming.KMP;

import java.util.*;


public class App {
    public static void main( String[] args ) {
        Map<Character, Integer> store = new TreeMap<>((x, y) -> Integer.compare(y,x));
    }


    public void test() {
        KMP example = new KMP("ababd");
        String str = "ababcabcabababd";
        int answer = example.isSubString(str);
        System.out.println(answer);
        System.out.println(str.substring(answer));
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
