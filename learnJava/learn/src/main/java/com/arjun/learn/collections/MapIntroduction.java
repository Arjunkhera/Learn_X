package com.arjun.learn.collections;

import java.time.LocalDate;
import java.util.*;

public class MapIntroduction {

  public static void main(String[] args) {
    introduction();
    sortedMap();

    // we can store collections as values since they are objects
    // although storing collections as keys is allowed, it should not be done
  }

  // exploring the Map interface
  public static void introduction() {
    Map<Character, Integer> count = new HashMap<>();
    String input = "abcbbccaadddeffgaaeegg";
    input
        .chars()
        .forEach(ch -> count.put((char) ch, count.getOrDefault((char) ch, 0) + 1));

    // Required Methods
    System.out.println("Map size is: " + count.size()); // Map size is: 7
    System.out.println("Is Map empty ? " + count.isEmpty()); // Is Map empty ? false
    System.out.println("Get value for c : " + count.get('c')); // Get value for c : 3
    System.out.println("Is key c present ? " + count.containsKey('c')); // Is key c present ? true
    System.out
        .println("Is value 1 present ? " + count.containsValue(1)); // Is value 1 present ? false
    System.out.println("Set of keys: " + count.keySet()); // Set of keys: [a, b, c, d, e, f, g]
    System.out.println(
        "Collection of values: " + count.values()); // Collection of values: [5, 3, 3, 3, 3, 2, 3]
    Set<Map.Entry<Character, Integer>> entrySet = count.entrySet();
    for (var entry : entrySet) {
      System.out.print("[" + entry.getKey() + ", " + entry.getValue() + "],");
    }
    System.out.println(""); // [a, 5],[b, 3],[c, 3],[d, 3],[e, 3],[f, 2],[g, 3],

    // Optional Methods
    System.out
        .println("Add key z and value 1 : " + count.put('z', 1)); // Add key z and value 1 : null
    System.out.println("Remove key z : " + count.remove('z')); // Remove key z : 1
    // count.putAll(Collection);
    // count.clear();

    // Default Methods
    System.out
        .println("Get h or default 0 : " + count.getOrDefault('h', 0)); // Get h or default 0 : 0
    System.out.println("Put key value pair if not present: " + count.putIfAbsent('h', 1));
    System.out.println("Replace by value if current pair matches : " + count.replace('h', 1, 2));
    System.out.println("Replace by new value : " + count.replace('a', 1));
    System.out.println("Remove if exact key and value match : " + count.remove('h', 2));
    // Return original, otherwise add value returned from lambda
    System.out
        .println("Compute if absent : " + count.computeIfAbsent('b', (k) -> "Arjun".length()));
    // If key is present, calculate new value from lambda and overwrite if new value is not null, else remove key
    System.out.println(
        "Compute if present : " + count.computeIfPresent('c', (k, v) -> "Arjun".length() + v));
    // Calculate new value from lambda and overwrite if not null, else remove old. Operation carried regardless
    System.out.println("Compute : " + count.compute('c', (k, v) -> "Arjun".length() + v));
    // Simply loop over all values
    count.forEach((key, value) -> System.out.print("[" + key + ", " + value + "],"));
    System.out.println("");
  }

  public static void mapEntrySet() {
    Map<Character, Integer> count = new HashMap<>();
    String input = "abcbbccaadddeffgaaeegg";
    input.chars().forEach(ch -> count.put((char) ch, count.getOrDefault((char) ch, 0) + 1));

    Set<Map.Entry<Character, Integer>> entry = count.entrySet();
    Iterator<Map.Entry<Character, Integer>> iterator = entry.iterator();

    Map.Entry<Character, Integer> first = iterator.next();
    System.out.println("First key: " + first.getKey());
    System.out.println("First value: " + first.getValue());
    System.out.println("Modify value: " + first.setValue(3));
  }

  public static void immutableMap() {
    // Immutable Maps
    Map<String, String> emptyMap = Map.of();

    Map<String, String> friendPhones = Map.of(
        "Bob", "+1-202-555-0118",
        "James", "+1-202-555-0220",
        "Katy", "+1-202-555-0175"
    );
  }

  public static void sortedMap() {
    SortedMap<Character, Integer> sortedMap = new TreeMap<>();

    String randomString = "askvalskvjalmawnfkasjskfjalskjfmsvaskjflaoweuriwizxmncvzmn";
    randomString
        .chars()
        .forEach(ch -> sortedMap.put((char) ch, sortedMap.getOrDefault((char) ch, 0)));

    System.out.println("First Key : " + sortedMap.firstKey());
    System.out.println("Last Key : " + sortedMap.lastKey());

    System.out.println("Key values less than o " + sortedMap.headMap('o').keySet());
    System.out.println("Key values greater than equal to o " + sortedMap.tailMap('o').keySet());
    System.out
        .println("Key values between j and r(excluded) : " + sortedMap.subMap('j', 'r').keySet());
  }

  public static void treeMap() {
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
