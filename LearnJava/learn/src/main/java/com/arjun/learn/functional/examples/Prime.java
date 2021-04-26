package com.arjun.functional.examples;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Prime {
    private static boolean isPrimeFirst(long number) {
        long numberOfDivisors = LongStream
                .range(2, number)
                .filter(n -> number % n == 0)
                .count();

        return numberOfDivisors == 0;
    }

    private static boolean isPrimeSecond(long number) {
        return IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(i -> number % i == 0);
    }
}
