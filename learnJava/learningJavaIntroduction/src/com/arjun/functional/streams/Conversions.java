package com.arjun.functional.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Conversions {

    public static void main(String[] args) {
        creatingStreams();
    }

    public static void creatingStreams() {
        // Given an array
        int[] arr = new int[]{1,2,3,4};

        // Either directly create stream of primitive type if int, long or double is provided
        IntStream intStream = Arrays.stream(arr);

        Integer[] referenceArray = new Integer[]{1,2,3,4};
        // To create a reference type stream, either create a collection first
        // First two create immutable collections,
        // The second was introduced in java 9 and is preferred over first
        List<Integer> firstMethod = Arrays.asList(referenceArray);
        List<Integer> secondMethod = List.of(referenceArray);
        // For mutable collections, we can supply them during initialisation
        List<Integer> thirdMethod = new ArrayList<Integer>(Arrays.asList(referenceArray));

        // Or directly convert the stream using boxed
        Stream<Integer> integerWrapperStream = Arrays.stream(arr).boxed();
        Stream<Integer> directArrayConversion = Arrays.stream(referenceArray);

        // Collections can be directly converted through .stream methods
        List<Integer> famousNumbers = List.of(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55);
        Stream<Integer> numbersStream = famousNumbers.stream();

        Set<String> usefulConcepts = Set.of("functions", "lazy", "immutability");
        Stream<String> conceptsStream = usefulConcepts.stream();

        Stream<Double> doubleStream = Arrays.stream(new Double[]{ 1.01, 1d, 0.99, 1.02, 1d, 0.99 });

        // Streams can also be directly initialised
        Stream<String> persons = Stream.of("John", "Demetra", "Cleopatra");
        String[] arrayOfStrings = new String[]{"arjun", "khera"};
        Stream<String> people = Stream.of(arrayOfStrings);

        Stream<String> stream1 = Stream.of(/* some values */);
        Stream<String> stream2 = Stream.of(/* some values */);
        Stream<String> resultStream = Stream.concat(stream1, stream2);

        // Create empty streams to use as return values from functions
        Stream<Integer> empty1 = Stream.of();
        Stream<Integer> empty2 = Stream.empty();
    }
}
