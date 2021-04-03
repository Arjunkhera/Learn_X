package com.arjun.functional;

import java.util.function.*;

public class StandardTypes {
    // Official Reference
    // https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
    public static void main(String[] args) {
        functions();
        operators();
        predicates();
        suppliers();
        consumers();
    }

    // accept arguments and produce results
    public static void functions() {
        // String to Integer function
        Function<String, Integer> converter = Integer::parseInt;
        converter.apply("1000"); // the result is 1000 (Integer)

        // String to int function
        ToIntFunction<String> anotherConverter = Integer::parseInt;
        anotherConverter.applyAsInt("2000"); // the result is 2000 (int)

        // (Integer, Integer) to Integer function
        BiFunction<Integer, Integer, Integer> sumFunction = Integer::sum;
        sumFunction.apply(2, 3); // it returns 5 (Integer)
    }

    // product results of the same type as their arguments
    // they are a subset of functions
    public static void operators() {
        // int to int operator
        IntUnaryOperator intMultiplier = val -> 100 * val;
        intMultiplier.applyAsInt(10); // the result is 1000 (int)

        // Long to Long multiplier
        UnaryOperator<Long> longMultiplier = val -> 100_000 * val;
        longMultiplier.apply(2L); // the result is 200_000L (Long)

        // (String, String) to String operator
        BinaryOperator<String> appender = (str1, str2) -> str1 + str2;
        appender.apply("str1", "str2"); // the result is "str1str2"
    }

    // return boolean values and accept any arguments
    public static void predicates() {
        // int to boolean predicate
        IntPredicate isEven = val -> val % 2 == 0;
        isEven.test(10); // the result is true (boolean)

        // Character to boolean predicate
        Predicate<Character> isDigit = Character::isDigit;
        isDigit.test('h'); // the result is false (boolean)
    }

    // return values and accept nothing
    public static void suppliers() {
        Supplier<String> stringSupplier = () -> "Hello";
        stringSupplier.get(); // the result is "Hello" (String)

        BooleanSupplier booleanSupplier = () -> true;
        booleanSupplier.getAsBoolean(); // the result is true (boolean)

        IntSupplier intSupplier = () -> 33;
        intSupplier.getAsInt(); // the result is 33 (int)
    }

    // accept arguments and return no result
    public static void consumers() {
        // it prints a given string
        Consumer<String> printer = System.out::println;
        printer.accept("!!!"); // It prints "!!!"
    }
}
