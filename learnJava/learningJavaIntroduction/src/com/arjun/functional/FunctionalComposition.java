package com.arjun.functional;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;

public class FunctionalComposition {
    public static void main(String[] args) {
        composingFunctions();
        composingPredicates();
        composingConsumer();
    }

    public static void composingFunctions() {
        // f.compose(g).apply(x) is equivalent to f(g(x))
        // f.andThen(g).apply(x) is equivalent to g(f(x))

        Function<Integer, Integer> adder = x -> x + 10;
        Function<Integer, Integer> multiplier = x -> x * 5;

        // compose: adder(multiplier(5))
        System.out.println("result: " + adder.compose(multiplier).apply(5));

        // andThen: multiplier(adder(5))
        System.out.println("result: " + adder.andThen(multiplier).apply(5));


    }

    public static void composingPredicates() {
        // there are three methods available to predicates for composing
        // and, or, negate

        IntPredicate isOdd = n -> n % 2 != 0; // it's true for 1, 3, 5, 7, 9, 11 and so on

        System.out.println(isOdd.test(10)); // prints "false"
        System.out.println(isOdd.test(11)); // prints "true"

        IntPredicate lessThan11 = n -> n < 11; // it's true for all numbers < 11

        System.out.println(lessThan11.test(10)); // prints "true"
        System.out.println(lessThan11.test(11)); // prints "false"

        IntPredicate isEven = isOdd.negate(); // it's true for 0, 2, 4, 6, 8, 10 and so on
        System.out.println(isEven.test(10)); // prints "true"
        System.out.println(isEven.test(11)); // prints "false"

        IntPredicate isOddOrLessThan11 = isOdd.or(lessThan11);

        System.out.println(isOddOrLessThan11.test(10)); // prints "true"
        System.out.println(isOddOrLessThan11.test(11)); // prints "true"
        System.out.println(isOddOrLessThan11.test(12)); // prints "false"
        System.out.println(isOddOrLessThan11.test(13)); // prints "true"

        IntPredicate isOddAndLessThan11 = isOdd.and(lessThan11);

        System.out.println(isOddAndLessThan11.test(8));  // prints "false"
        System.out.println(isOddAndLessThan11.test(9));  // prints "true"
        System.out.println(isOddAndLessThan11.test(10)); // prints "false"
        System.out.println(isOddAndLessThan11.test(11)); // prints "false"
    }

    public static void composingConsumer() {
        // we can chain several consumers to consume provided value

        Consumer<String> consumer = System.out::println;
        Consumer<String> doubleConsumer = consumer.andThen(System.out::println);
        doubleConsumer.accept("Hi!");
    }
}
