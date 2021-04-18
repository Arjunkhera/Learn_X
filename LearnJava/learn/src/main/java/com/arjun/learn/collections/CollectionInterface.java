package com.arjun.learn.collections;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionInterface {
    public static void main(String[] args) {
        introduction();
    }

    // some common methods for collection interface
    public static void introduction() {
        Collection<String> example = new ArrayList<String>();

        example.add("1");
        example.add("2");
        example.add("3");
        example.add("4");

        System.out.println("size: " + example.size());
        System.out.println("is empty ? " + example.isEmpty());
        System.out.println("contains 3 ? " + example.contains("3"));

        // using method reference to print elements
        example.forEach(System.out::println);

        example.removeIf(element -> element.startsWith("2"));
        example.forEach(element -> System.out.println(element));

        System.out.println(example.remove("3"));
        System.out.println(example.removeAll(List.of("1","2")));
        example.clear();
    }

    // immutable collection
    public static void immutable() {
        Collection<String> concrete = List.of("a","b","c");
    }
}
