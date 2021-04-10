package com.arjun.learn;

import com.arjun.learn.algorithms.graphs.Traversal;
import com.arjun.learn.algorithms.graphs.TraversalString;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main( String[] args ) throws IOException {
        int[] arr = {2,0,2,1,1,0};
        sortColors(arr);
    }

    public static void sortColors(int[] A) {
        int n = A.length;
        int j = 0, k = n-1, temp;
        for (int i=0; i <= k; i++) {
            if (A[i] == 0) {
                temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                j++;
            }
            else if (A[i] == 2) {
                temp = A[i];
                A[i] = A[k];
                A[k] = temp;
                i--; k--;
            }
        }
    }
}