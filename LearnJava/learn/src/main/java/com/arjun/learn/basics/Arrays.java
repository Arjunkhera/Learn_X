package com.arjun.learn.basics;

public class Arrays {
    public static void main(String[] args) {
        System.out.println("-------");
        commonMethods();

        System.out.println("-------");
        introductionToArrays();

        System.out.println("-------");
        miscellaneous();
    }

    public static void declaration() {
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
        // or simply
        int[] sixthArray = new int[]{1,2,3};
    }

    public static void multiDimensional() {
        // declaration
        int[][] twoDDeclared;

        // following is wrong
        // int[][] twoD = new int[][3];
        // we need to specify row count while instantiating
        int[][] twoD = new int[3][];

        // initializing 2d arrays
        int[][] twoDFirstInitialised = {{1,2}, {3,4}};
        // another way
        int[][] twoDSecondInitialised = new int[][] {{1,2}, {3,4,5,6}, {7}};

        // we can do this for higher dimensions as well
        int[][][] threeD = new int[3][][];

        // initialised three dimensional array
        int[][][] threeDInitialised = {{{1,2}}, {{3,4}}};

        // looping elements
        for(int i = 0; i < twoDSecondInitialised.length; i++) {
            for(int j = 0; j < twoDSecondInitialised[i].length; j++) {
                System.out.print(twoDSecondInitialised[i][j] + " ");
            }
            System.out.println();
        }
        // another way
        for(int[] arr : twoDSecondInitialised) {
            for(int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void commonMethods() {
        int[] firstArray = {1,2,3,4,5};

        // Finding the length of the array
        System.out.println(firstArray.length);
    }

    public static void introductionToArrays() {
        int[] firstArray = {1,2,3,4,5};

        // Converting array to string
        System.out.println(java.util.Arrays.toString(firstArray));

        int[] secondArray = {3,1,10,8,5};
        java.util.Arrays.sort(secondArray);
        System.out.println(java.util.Arrays.toString(secondArray));

        // checking equality of Arrays : elements should match for every index
        int[] thirdArray = {1,2,3,4,5};

        System.out.println(java.util.Arrays.equals(firstArray,secondArray));  // false
        System.out.println(java.util.Arrays.equals(firstArray,thirdArray));   // true

        // filling array with Characters
        int size = 10;
        char[] fourthArray = new char[size];

        java.util.Arrays.fill(fourthArray,0, size/2, 'A');
        java.util.Arrays.fill(fourthArray, size/2, size, 'B');
        System.out.println(java.util.Arrays.toString(fourthArray));
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
