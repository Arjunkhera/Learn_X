package com.arjun.learn.introduction;

import java.util.Comparator;

public class Arrays {

  public static void main(String[] args) {
    Arrays introduction = new Arrays();

    System.out.println("Introduction");
    introduction.introduction();
    System.out.println("------------");

    System.out.println("Arrays Utility Methods");
    introduction.arraysUtilityMethods();
    System.out.println("------------");

    System.out.println("Multi Dimensional Arrays");
    introduction.twoDimensionalArrays();
    System.out.println("------------");

    System.out.println("Arrays Sorting");
    introduction.sortingArrays();
    System.out.println("------------");

    System.out.println("Miscellaneous");
    introduction.miscellaneous();
    System.out.println("------------");
  }

  public void introduction() {
    // Arrays are reference types

    // Declaration method one : prominent
    int[] firstArray;
    // Declaration method two : less used
    int secondArray[];

    // Initialisation of values
    int[] thirdArray = {1, 2, 3};

    // Declaring through the new keyword : array here is of length 3
    // Also, here we perform both declaration and instantiation
    int[] fourthArray = new int[3];
    // All the elements are initialised with values zero
    for (int i : fourthArray) {
      System.out.println(i);
    }

    // we can initialise for new also
    String[] fifthArray;
    fifthArray = new String[]{"Java", "C++"};
    for (String i : fifthArray) {
      System.out.println(i);
    }

    // one inbuilt method in arrays to find length
    System.out.println(fifthArray.length);
  }

  public void arraysUtilityMethods() {
    int[] firstArray = {1, 2, 3, 4, 5};

    // Converting array to string
    System.out.println(java.util.Arrays.toString(firstArray));

    int[] secondArray = {3, 1, 10, 8, 5};
    java.util.Arrays.sort(secondArray);
    System.out.println(java.util.Arrays.toString(secondArray));

    // checking equality of Arrays : elements should match for every index
    int[] thirdArray = {1, 2, 3, 4, 5};

    System.out.println(java.util.Arrays.equals(firstArray, secondArray));  // false
    System.out.println(java.util.Arrays.equals(firstArray, thirdArray));   // true
    // We can pass comparators to equals when comparing objects

    // filling array with characters
    int size = 10;
    char[] fourthArray = new char[size];

    java.util.Arrays.fill(fourthArray, 0, size / 2, 'A');
    java.util.Arrays.fill(fourthArray, size / 2, size, 'B');
    System.out.println(java.util.Arrays.toString(fourthArray));
  }

  public void twoDimensionalArrays() {
    int[][] twoD = {
        {19, 2},
        {1, 7},
        {10, 11},
        {3, 21}
    };

    java.util.Arrays.sort(twoD, Comparator.comparingInt(a -> a[0]));
    for (int[] row : twoD) {
      System.out.println(java.util.Arrays.toString(row));
    }
  }

  public void sortingArrays() {
    // Single Index Sorting
    int[] array = {3, 1, 10, 8, 5};
    java.util.Arrays.sort(array);
    System.out.println(java.util.Arrays.toString(array)); // [1, 3, 5, 8, 10]
    System.out.println("------------");

    // TwoDimensional Index Sorting
    int[][] rooms = {{7, 14}, {11, 6}, {3, 1}, {9, 4}, {14, 14}, {17, 11}, {22, 13}, {6, 25},
        {12, 22}, {21, 9}};
    // Original
    for (var room : rooms) // [7:14],[11:6],[3:1],[9:4],[14:14],[17:11],[22:13],[6:25],[12:22],[21:9],
    {
      System.out.printf("[%d:%d],", room[0], room[1]);
    }
    System.out.println("\n------------");

    // Ascending Order : default
    // If first index is used, or default object comparable is used
    // no need to provide comparator
    // If any other index or property is required, use Comparator
    int[][] ascending = java.util.Arrays.stream(rooms).map(int[]::clone).toArray(int[][]::new);
    java.util.Arrays.sort(ascending, Comparator.comparingInt(a -> a[1]));
    // Comparator.comparing(object -> object.method()); is a general way of comparing
    for (var room : ascending) // [3:1],[9:4],[11:6],[21:9],[17:11],[22:13],[7:14],[14:14],[12:22],[6:25],
    {
      System.out.printf("[%d:%d],", room[0], room[1]);
    }
    System.out.println("\n------------");

    // Descending Order
    int[][] descending = java.util.Arrays.stream(rooms).map(int[]::clone).toArray(int[][]::new);
    java.util.Arrays.sort(descending, (a, b) -> Integer.compare(b[1], a[1]));
    for (var room : descending) // [6:25],[12:22],[7:14],[14:14],[22:13],[17:11],[21:9],[11:6],[9:4],[3:1],
    {
      System.out.printf("[%d:%d],", room[0], room[1]);
    }
    System.out.println("\n------------");

    // Note : order is maintained while sorting,
    // hence [7:14] will come before [14:14] in sorted string
  }

  public void cloningArrays() {
    int[] original = new int[]{1, 2, 3};
    int[] clone = original.clone();
  }

  public void miscellaneous() {

    char[] firstArray = new char[1];
    for (char c : firstArray) {
      System.out.print(c + " ");
    }
    System.out.println("");

    char[] secondArray = new char[0];
    for (char c : secondArray) {
      System.out.print(c + " ");
    }
    System.out.println("");

    // The following would compile, but gives NegativeArraySizeException at runtime
//    char[] thirdArray = new char[-1];
//    for (char c : thirdArray) {
//      System.out.print(c + " ");
//    }
//    System.out.println("");

    char[] fourthArray = {'a', 'b', 'c'};
    for (char c : fourthArray) {
      System.out.print(c + " ");
    }
    System.out.println("");

    // The following would not compile, largest possible size is Integer.MAX_VALUE
    // char[] fifthArray = new char[100000000000];
    System.out.println(Integer.MAX_VALUE);
  }
}
