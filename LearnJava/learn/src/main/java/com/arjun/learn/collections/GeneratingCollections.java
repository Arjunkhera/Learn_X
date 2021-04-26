package com.arjun.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GeneratingCollections {
    public static void main(String[] args) {
        listsFromArrayOfPrimitives();;
        listsFromArrayOfReferences();
        initialisingNewLists();
    }

    public static void listsFromArrayOfPrimitives() {
        // given an array of primitives
        int[] arr = new int[]{1,2,3};

        // cannot directly generate since type is not reference

        // Option 1 : Loop
        ArrayList<Integer> first = new ArrayList<>();
        for(int i : arr) {
            // single element autoboxing is allowed
            first.add(i);
        }

        // Option 2 : Use Streams
        List<Integer> second = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());

        // Option 3 : Use IntStream
        List<Integer> third = IntStream.of(arr)
                .boxed()
                .collect(Collectors.toList());

        // For generating arraylist you need to generate an
        // Integer array first or a List of Integer and then use that
    }

    public static void listsFromArrayOfReferences() {
        Integer[] arr = new Integer[]{1,2,3};

        // Create Immutable Collections
        List<Integer> first = Arrays.asList(arr);
        List<Integer> second = List.of(arr);

        // both of the above are simply wrappers around the array
        // modification to arr will reflect across those two
        // also List.of is preferred

        // Create new collections
        ArrayList<Integer> third = new ArrayList<>(first);
        // use any of the list interface methods defined above

        // Using streams
        // But this is immutable
        List<Integer> fourth = Arrays.stream(arr).
                collect(Collectors.toList());

        ArrayList<Integer> fifth = Arrays.stream(arr)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static void initialisingNewLists() {
        // Immutable Collection
        List<Integer> first = List.of(1,2,3);
        // following would give an error
        // arr.add(4);
        Integer[] arr = new Integer[]{1,2};
        List<Integer> second = Arrays.stream(arr).collect(Collectors.toList());

        // Mutable Collections need to define a type
        ArrayList<Integer>  third = new ArrayList<>();

        // Initialising
        ArrayList<Integer> fourth = new ArrayList<>(second);
        ArrayList<Integer> fifth = Arrays.stream(arr)
                .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> sixth = new ArrayList() {{
            add(1);
            add(2);
        }};
    }
}
