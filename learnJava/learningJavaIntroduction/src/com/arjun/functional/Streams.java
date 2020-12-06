package com.arjun.functional;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {
        creatingStreams();
        examples();
    }

    public static void creatingStreams() {
        List<Integer> famousNumbers = List.of(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55);
        Stream<Integer> numbersStream = famousNumbers.stream();

        Set<String> usefulConcepts = Set.of("functions", "lazy", "immutability");
        Stream<String> conceptsStream = usefulConcepts.stream();

        Stream<Double> doubleStream = Arrays.stream(new Double[]{ 1.01, 1d, 0.99, 1.02, 1d, 0.99 });

        Stream<String> persons = Stream.of("John", "Demetra", "Cleopatra");
        IntStream intStream = IntStream.of(1,2,3);

        Stream<String> stream1 = Stream.of(/* some values */);
        Stream<String> stream2 = Stream.of(/* some values */);
        Stream<String> resultStream = Stream.concat(stream1, stream2);

        // Create empty streams to use as return values from functions
        Stream<Integer> empty1 = Stream.of();
        Stream<Integer> empty2 = Stream.empty();
    }

    public static void examples() {
        List<Integer> numbers = List.of(1, 4, 7, 6, 2, 9, 7, 8);

        long count = numbers.stream()
                .skip(4)  // skip 1, 4, 7, 6
                .filter(number -> number > 5)
                .count();  // 3

        List<String> companies = List.of(
                "Google", "Amazon", "Samsung",
                "GOOGLE", "amazon", "Oracle"
        );

        companies.stream()
                .map(String::toUpperCase) // transform each name to the upper case
                .distinct() // intermediate operation: keep only unique words
                .forEach(System.out::println); // print every company
    }
}
