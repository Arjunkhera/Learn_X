package com.arjun.collections;

import java.time.LocalDate;
import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        introduction();
        mapTypes();

        // we can store collections as values since they are objects
        // although storing collections as keys is allowed, it should not be done
    }

    // exploring the Map interface
    public static void introduction() {
        Map<Character, Integer> count = new HashMap<>();
        String input = "abcbbccaadddeffgaaeegg";
        input.chars()
                .forEach(ch -> count.put((char) ch, count.getOrDefault((char)ch, 0) + 1));

        // Methods common to collection interface
        System.out.println(count.size());
        System.out.println(count.isEmpty());
        // count.clear();

        // Key and Value processing
        System.out.println(count.get('c'));
        System.out.println(count.put('z', 1));
        System.out.println(count.remove('z'));
        System.out.println(count.containsKey('c'));
        System.out.println(count.containsValue(1));

        // Miscellaneous
        System.out.println(count.getOrDefault('h', 0));
        System.out.println(count.putIfAbsent('h', 1));

        // Return other collections
        System.out.println(count.keySet()); // returns set of keys
        System.out.println(count.values()); // returns collection of values

        // Printing all elements
        Set<Map.Entry<Character, Integer>> entrySet = count.entrySet();
        entrySet.forEach(entry -> System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue()));
        // or simply
        count.forEach((key, value) -> System.out.println("Key: " + key + " Value: " + value));
        // another way : here entry is Map.Entry<Character, Integer>
        for(var entry : count.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }

    }

    public static void mapTypes() {
        // Immutable Maps
        Map<String, String> emptyMap = Map.of();

        Map<String, String> friendPhones = Map.of(
                "Bob", "+1-202-555-0118",
                "James", "+1-202-555-0220",
                "Katy", "+1-202-555-0175"
        );

        // Hash Map : fastest read and writes, no ordering provided
        // examples above

        // LinkedHashMap : slower than hash map, insertion ordering provided
        Map<Integer, String> products = new LinkedHashMap<>(); // ordered map of products

        products.put(1000, "Notebook");
        products.put(2000, "Phone");
        products.put(3000, "Keyboard");

        System.out.println(products);

        // TreeMap : ordering is defined basis provided comparator
        // implements Sorted Map which has additional methods
        SortedMap<LocalDate, String> events = new TreeMap<>();

        events.put(LocalDate.of(2017, 6, 6), "The Java Conference");
        events.put(LocalDate.of(2017, 6, 7), "Another Java Conference");
        events.put(LocalDate.of(2017, 6, 8), "Discussion: career or education?");
        events.put(LocalDate.of(2017, 6, 9), "The modern art");
        events.put(LocalDate.of(2017, 6, 10), "Coffee master class");

        LocalDate fromInclusive = LocalDate.of(2017, 6, 8);
        LocalDate toExclusive = LocalDate.of(2017, 6, 10);

        System.out.println(events.tailMap(fromInclusive));
        System.out.println(events.subMap(fromInclusive, toExclusive));
        System.out.println(events.firstKey());
        System.out.println(events.lastKey());
    }
}
