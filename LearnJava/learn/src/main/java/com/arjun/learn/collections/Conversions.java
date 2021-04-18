package com.arjun.learn.collections;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Conversions {
    public void arrayToList() {
        Integer[] arrInteger = {1,2,3,4,5};
        String[] strings = {"arjun", "khera"};

        // Immutable List : from Objects

        // Method 1
        List<Integer> listArrInteger = Arrays.asList(arrInteger);
        // Method 2 : Introduced in Java 9
        List<String> listStrings = List.of(strings);

        // Mutable List : from Objects
        listArrInteger = new ArrayList<>(Arrays.asList(arrInteger));
        listStrings = new ArrayList<>(List.of(strings));

        // Primitives
        int[] arr = {1,2,3,4,5};

        // Method 1 : Loop
        List<Integer> arrLoop = new ArrayList<>();
        for(int i : arr)
            arrLoop.add(i);
        // Method 2 : Use stream to convert to Wrappers first
        List<Integer> arrStream = Arrays.stream(arr).boxed().collect(Collectors.toList());
        // we can also use IntStream
        List<Integer> intStream = IntStream.of(arr).boxed().collect(Collectors.toList());
    }

    public void listToArray() {
        List<Integer> list = List.of(1,2,3,4,5);
        Integer[] wrapper = list.toArray(new Integer[0]);
        // Another method introduced in Java 11
        wrapper = list.toArray(Integer[]::new);

        // Need to convert to int stream before generating array
        int[] primitive = list.stream().mapToInt(Integer::intValue).toArray();
    }

    public void arrayToSet() {
        Integer[] arrInteger = {1,2,3,4,5,1,4};
        String[] strings = {"arjun", "khera", "arjun"};

        // Immutable List : from Objects
        // Method 1
        Set<String> listStrings = Set.of(strings);

        // Mutable List : from Objects
        // Provide a List
        Set<Integer> setArrInteger = new HashSet<>(Arrays.asList(arrInteger));
        setArrInteger = new HashSet<>(List.of(arrInteger));
        // Or directly a Set
        listStrings = new HashSet<>(Set.of(strings));

        // Primitives
        int[] arr = {1,2,3,4,5};

        // Method 1 : Loop
        Set<Integer> arrLoop = new HashSet<>();
        for(int i : arr)
            arrLoop.add(i);
        // Method 2 : Use stream to convert to Wrappers first
        Set<Integer> arrStream = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        // we can also use IntStream
        Set<Integer> intStream = IntStream.of(arr).boxed().collect(Collectors.toSet());
    }

}
