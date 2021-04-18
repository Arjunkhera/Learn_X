package com.arjun.learn.introduction;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysIntroduction {

    public static void main(String[] args) {
//        introduction();
//        System.out.println("------------");
//
//        commonMethods();
//        System.out.println("------------");

//        introductionToArrays();
//        System.out.println("------------");

        twoDimensionalArrays();
        System.out.println("------------");
//
//        miscellaneous();
//        System.out.println("------------");
    }

    public static void introduction() {
        // Arrays are reference types

        // Declaration method one : prominent
        int[] firstArray;
        // Declaration method two : less used
        int secondArray[];

        // Initialisation of values
        int[] thirdArray = {1,2,3};

        // Declaring through the new keyword : array here is of length 3
        // Also, here we perform both declaration and instantiation
        int[] fourthArray = new int[3];
        // All the elements are initialised with values zero
        for ( int i : fourthArray ) {
            System.out.println(i);
        }

        // we can initialise for new also
        String[] fifthArray;
        fifthArray = new String[] {"Java","C++"};
        for ( String i : fifthArray ) {
            System.out.println(i);
        }

        System.out.println("-------");
        commonMethods();

        System.out.println("-------");
        introductionToArrays();

        System.out.println("-------");
        miscellaneous();
    }

    public static void commonMethods() {
        int[] firstArray = {1,2,3,4,5};

        // Finding the length of the array
        System.out.println(firstArray.length);
    }

    public static void introductionToArrays() {
        int[] firstArray = {1,2,3,4,5};

        // Converting array to string
        System.out.println(Arrays.toString(firstArray));

        int[] secondArray = {3,1,10,8,5};
        Arrays.sort(secondArray);
        System.out.println(Arrays.toString(secondArray));

        // checking equality of Arrays : elements should match for every index
        int[] thirdArray = {1,2,3,4,5};

        System.out.println(Arrays.equals(firstArray,secondArray));  // false
        System.out.println(Arrays.equals(firstArray,thirdArray));   // true

        // filling array with characters
        int size = 10;
        char[] fourthArray = new char[size];

        Arrays.fill(fourthArray,0, size/2, 'A');
        Arrays.fill(fourthArray, size/2, size, 'B');
        System.out.println(java.util.Arrays.toString(fourthArray));
    }

    public static void twoDimensionalArrays() {
        int[][] twoD = {
                {19,2},
                {1,7},
                {10,11},
                {3,21}
        };

        Arrays.sort(twoD, Comparator.comparingInt(a -> a[0]));
        for(int[] row: twoD) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void miscellaneous() {

        char[] firstArray = new char[1];
        for ( char c : firstArray ) {
            System.out.print(c + " ");
        }
        System.out.println("");

        char[] secondArray = new char[0];
        for ( char c : secondArray ) {
            System.out.print(c + " ");
        }
        System.out.println("");

        // The following would compile, but gives NegativeArraySizeException at runtime
//        char[] thirdArray = new char[-1];
//        for ( char c : thirdArray ) {
//            System.out.print(c + " ");
//        }
//        System.out.println("");

        char[] fourthArray = {'a','b','c'};
        for ( char c : fourthArray ) {
            System.out.print(c + " ");
        }
        System.out.println("");

        // The following would not compile, largest possible size is Integer.MAX_VALUE
        // char[] fifthArray = new char[100000000000];
        System.out.println(Integer.MAX_VALUE);
    }
}
