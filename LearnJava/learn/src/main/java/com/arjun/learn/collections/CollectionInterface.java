package com.arjun.learn.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionInterface {
    // some common methods for collection interface
    public void introduction() {
        Collection<String> example = new ArrayList<>();

        example.add("1");
        example.add("2");
        example.add("3");
        example.add("4");
        example.forEach(element -> System.out.print(element + " "));
        System.out.println("");

        System.out.println("size: " + example.size());
        System.out.println("is empty ? " + example.isEmpty());
        System.out.println("contains 3 ? " + example.contains("3"));

        System.out.println(example.remove("3"));
        example.removeIf(element -> element.startsWith("2"));
        // using method reference to print elements
        example.forEach(System.out::print);
        System.out.println("");

        Collection<Integer> original = new ArrayList<>(List.of(1,2,3,4,5));
        Collection<Integer> first = new ArrayList<>(original);
        Collection<Integer> second = new ArrayList<>(List.of(4,5,6,7,8));

        // Union of collection first and second
        first.addAll(second);
        first.forEach(element -> System.out.print(element + " "));
        System.out.println("");

        // Intersection of collection first and second
        first = new ArrayList<>(original);
        first.retainAll(second);
        first.forEach(element -> System.out.print(element + " "));
        System.out.println("");

        // Set subtraction first - second
        first = new ArrayList<>(original);
        first.removeAll(second);
        first.forEach(element -> System.out.print(element + " "));
        System.out.println("");

        // Remove all elements
        example.clear();
    }

    // immutable collection
    public static void immutable() {
        Collection<String> concrete = List.of("a","b","c");
    }
}
