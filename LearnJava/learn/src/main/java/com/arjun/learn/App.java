package com.arjun.learn;


import com.arjun.learn.algorithms.dynamicprogramming.KMP;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.UUID;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class App {

    public static void main(String[] args ) throws IOException {
        System.out.println(Math.ceil(5.0/2));
        System.out.println((int)Math.ceil(5.0/2));
    }

    public static int gcd(int a, int b) {
        if(b == 0)
            return a;
        return gcd(b, a%b);
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
