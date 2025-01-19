package com.arjun.collections.examples;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReadingInput {
    public static void main(String[] args) {
        readingIntegers();
    }

    public static void readingIntegers() {
        List<Integer> check = Arrays.asList(1,2,3);
        check.add(5);

        Scanner scanner = new Scanner(System.in);
        Stream<Integer> integerStream = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt);
    }
}
