package com.arjun.learn.algorithms.sorting;

import org.junit.Test;

import java.util.Arrays;

public class PartitionTest {
    int[] test = new int[]{-9,4,5,3,7,10,-20,100,16,39,48,12};

    @Test
    public void testPartition() {
        int[] input = test.clone();
        int index = Partition.partition(input, 0 , input.length - 1, 4);

        System.out.println(Arrays.toString(input));
        checkValidity(input, index);


        int[] sameElements = new int[5];
        Arrays.fill(sameElements, 5);
        index = Partition.partition(sameElements, 0, sameElements.length - 1, 2);

        System.out.println(Arrays.toString(sameElements));
        checkValidity(sameElements, index);
    }

    @Test
    public void semiSortTest() {
        int[] input = test.clone();
        int n = input.length, targetIndex = n/2;
        Partition.semiSort(input, 0, n - 1, targetIndex);
        System.out.println(Arrays.toString(input));
        checkValidity(input, targetIndex);
    }

    public void checkValidity(int[] input, int index) {
        for(int i = index - 1; i >= 0; i--)
            assert input[i] <= input[index];
        for(int i = index + 1; i < input.length; i++)
            assert input[i] >= input[index];
    }
}
