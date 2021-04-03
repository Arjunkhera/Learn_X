package com.arjun.collections;

import java.util.*;

public class CollectionsExample {
    public static void main(String[] args) {
        introduction();
        emptyAndSingleton();
    }

    public static void introduction() {
        var numbers = new ArrayList<>(List.of(1, 2, 3, 2, 3, 4)); // getting a mutable list

        Collections.sort(numbers);    // [1, 2, 2, 3, 3, 4]
        Collections.reverse(numbers); // [4, 3, 3, 2, 2, 1]
        Collections.shuffle(numbers); // randomly permutes the list

        System.out.println(numbers);  // a result can be any: [4, 2, 3, 2, 3, 1]

        Collections.rotate(numbers, 1);
        Collections.rotate(numbers, 2);
    }

    public static void emptyAndSingleton() {
        // Used to prevent NPE or in cases where we need to return collections
        List<String> emptyList = Collections.emptyList();
        Set<Integer> emptySet = Collections.emptySet();

        List<Integer> singletonList = Collections.singletonList(100);
        Set<String> singletonSet = Collections.singleton("Hello");
    }

    public static void calculations() {
        List<Integer> numbers = List.of(1, 2, 3, 2, 3, 4);

        System.out.println(Collections.frequency(numbers, 3)); // 2
        System.out.println(Collections.min(numbers)); // 1
        System.out.println(Collections.max(numbers)); // 4

        System.out.println(Collections.disjoint(numbers, List.of(1, 2))); // false
        System.out.println(Collections.disjoint(numbers, List.of(5, 6))); // true
    }
}
