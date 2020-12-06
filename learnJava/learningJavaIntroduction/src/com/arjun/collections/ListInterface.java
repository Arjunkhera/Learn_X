package com.arjun.collections;

import java.util.*;

public class ListInterface {
    public static void main(String[] args) {
        introduction();
        linkedList();
    }

    // methods in addition to collection interface
    public static void introduction() {
        List<String> example = new ArrayList<String>();

        example.add("1");
        example.add("2");
        example.add("3");
        example.add("4");
        example.add("2");

        System.out.println(example.set(2, "10"));
        System.out.println(example.get(3));
        System.out.println(example.indexOf("2"));
        System.out.println(example.lastIndexOf("2"));
        System.out.println(example.subList(1,3));
    }

    public static void linkedList() {
        List<Integer> numbers = new LinkedList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        System.out.println(numbers); // [10, 20, 30]
    }

    public static void listEquality() {
        Objects.equals(List.of(1, 2, 3), List.of(1, 2, 3));    // true
        Objects.equals(List.of(1, 2, 3), List.of(1, 3, 2));    // false
        Objects.equals(List.of(1, 2, 3), List.of(1, 2, 3, 1)); // false

        List<Integer> numbers = new ArrayList<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        Objects.equals(numbers, List.of(1, 2, 3)); // true
    }

    public void convertingArrayToList() {
        Integer[] arr = new Integer[]{1,2,3};
        // This just allows us to access arr through list interface
        // the backing is still the same, the array cannot be resized
        List<Integer> converted = Arrays.asList(arr);

        // the following would give error since converted is immutable
        // converted.add(3);
    }
}

