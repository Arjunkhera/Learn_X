package com.arjun.functional;

import java.util.function.Function;

public class Introduction {
    public static void main(String[] args) {
        basics();
    }

    @FunctionalInterface
    interface Func<T, R> {
        R apply(T val);

        static void doNothingStatic() {
        }

        default void doNothingByDefault() {
        }
    }

    // using functional interface
    public static void basics() {
        // using anonymous classes
        Func<Long, Long> square = new Func<Long, Long>() {
            @Override
            public Long apply(Long val) {
                return val * val;
            }
        };
        long val = square.apply(10L); // the result is 100L

        // using lambdas
        Func<Long, Long> squareLambda = x -> x * x; // the lambda expression
        Long newVal = squareLambda.apply(10L); // the result is 100L

        // passing functional interface to a function
        acceptFunctionalInterface(x -> x + 1);

        // using closures
        final String hello = "Hello, ";
        Function<String, String> helloFunction = (name) -> hello + name;

        System.out.println(helloFunction.apply("John"));
        System.out.println(helloFunction.apply("Anastasia"));
    }

    public static void acceptFunctionalInterface(Function<Integer, Integer> f) {
        System.out.println(f.apply(10));
    }
}
