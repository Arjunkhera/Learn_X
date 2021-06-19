package com.arjun.learn.collections;

import java.util.*;

public class SetIntroduction {
    public static void main(String[] args) {
        // introduction();
        System.out.println("---------------");

        // sortedSet();
        navigableSet();
    }

    public static void introduction() {

    }

    public static void immutableSet() {
        Set<String> emptySet = Set.of();
        Set<String> persons = Set.of("Larry", "Kenny", "Sabrina");
        Set<Integer> numbers = Set.of(100, 200, 300, 400);

        System.out.println(emptySet.contains("hello")); // false
        System.out.println(persons.contains("Sabrina")); // true
        System.out.println(persons.contains("John")); // false
        System.out.println(numbers.contains(300)); // true
    }

    public static void sortedSet() {
        SortedSet<Integer> sortedSet = new TreeSet<>();

        sortedSet.add(10);
        sortedSet.add(15);
        sortedSet.add(13);
        sortedSet.add(21);
        sortedSet.add(17);

        System.out.println(sortedSet); // [10, 13, 15, 17, 21]
        System.out.println(sortedSet.headSet(15)); // [10, 13]
        System.out.println(sortedSet.tailSet(15));
        System.out.println(sortedSet.subSet(13,21));

        System.out.println(sortedSet.first()); // minimum is 10
        System.out.println(sortedSet.last());  // maximum is 21
    }

    public static void navigableSet() {
        NavigableSet<Integer> navigableSet = new TreeSet<>(List.of(1, 3, 4, 7, 11, 14, 14, 19, 24));

        // Print in Ascending order
        for(Integer val : navigableSet)
            System.out.printf("%d ", val);
        System.out.println();

        // Remove first element
        navigableSet.pollFirst(); // removes 1
        // Remove last element
        navigableSet.pollLast(); // removes 24

        // Print in Descending order
        Iterator<Integer> iterator = navigableSet.descendingIterator();
        while (iterator.hasNext())
            System.out.printf("%d ", iterator.next());
        System.out.println();

        // Obtain the whole set in reverse
        NavigableSet<Integer> reversedSet = navigableSet.descendingSet();

        System.out.printf("Lower of 14 : %d \n", navigableSet.lower(14)); // 11
        System.out.printf("Floor of 14 : %d \n", navigableSet.floor(14)); // 14
        System.out.printf("Ceiling of 14 : %d \n", navigableSet.ceiling(14)); // 14
        System.out.printf("Higher of 14 : %d \n", navigableSet.higher(14)); // 19

        // Variations of headset and tailset
        // use the sorted set method
        SortedSet<Integer> headSetNormal = navigableSet.headSet(14);
        for(Integer val : headSetNormal)
            System.out.printf("%d ", val);
        System.out.println("----");

        // use boolean to indicate inclusion/exclusion of endpoints
        NavigableSet<Integer> headSetIncluded = navigableSet.headSet(14, true);
        for(Integer val : headSetIncluded)
            System.out.printf("%d ", val);
        System.out.println("----");
    }

    public static void hashSet() {
        Set<String> countries = new HashSet<>();

        countries.add("India");
        countries.add("Japan");
        countries.add("Switzerland");
        countries.add("Japan");
        countries.add("Brazil");

        System.out.println(countries); // [Japan, Brazil, Switzerland, India]
        System.out.println(countries.contains("Switzerland")); // true
    }

    public static void linkedHashSet() {
        Set<Character> characters = new LinkedHashSet<>();

        for (char c = 'a'; c <= 'k'; c++) {
            characters.add(c);
        }

        System.out.println(characters); // [a, b, c, d, e, f, g, h, i, j, k]
    }

    public static void setOperations() {
        // getting a mutable set from an immutable one
        Set<String> countries = new HashSet<>(List.of("India", "Japan", "Switzerland"));

        countries.addAll(List.of("India", "Germany", "Algeria"));
        System.out.println(countries ); // [Japan, Algeria, Switzerland, Germany, India]

        countries.retainAll(List.of("Italy", "Japan", "India", "Germany"));
        System.out.println(countries ); // [Japan, Germany, India]

        countries.removeAll(List.of("Japan", "Germany", "USA"));
        System.out.println(countries ); // [India]

        System.out.println(countries.containsAll(Set.of("India", "Japan")));   // true
    }

    public static void setEquality() {
        Objects.equals(Set.of(1, 2, 3), Set.of(1, 3));    // false
        Objects.equals(Set.of(1, 2, 3), Set.of(1, 2, 3)); // true
        Objects.equals(Set.of(1, 2, 3), Set.of(1, 3, 2)); // true

        Set<Integer> numbers = new HashSet<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        Objects.equals(numbers, Set.of(1, 2, 3)); // true
    }

}
