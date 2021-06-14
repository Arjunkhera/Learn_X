package com.arjun.learn;


import com.arjun.learn.algorithms.dynamicprogramming.KMP;
import java.util.TreeSet;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class App {
    public static void main( String[] args ) throws IOException {
        int a = 5;
        String fromInt = String.valueOf(a);
        int fromString = Integer.parseInt(fromInt);

    }

    public void testOld() {
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
