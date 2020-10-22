package com.arjun.functional;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferences {
    public static void main(String[] args) {
        basics();
    }

    public static void basics() {
        // using lambda
        Consumer<String> printer = str -> System.out.println(str);
        // using lambda with method reference
        Consumer<String> newPrinter = System.out::println;
    }

    public static void types() {
        // reference to a static method
        Function<Double, Double> sqrt = Math::sqrt;
        sqrt.apply(100.0d); // the result is 10.0d

        // reference to an instance method of an existing object
        Scanner scanner = new Scanner(System.in); // IO scanner

        Supplier<String> lineReader = scanner::nextLine; // method reference
        String firstLine = lineReader.get();
        String secondLine = lineReader.get();

        // reference to an instance method of an object of a particular type
        Function<Long, Double> converter = Long::doubleValue;
        converter.apply(100L); // the result is 100.0d
        converter.apply(200L); // the result is 200.0d

        // reference to a constructor
        Supplier<String> generator = String::new;
        String str = generator.get();
    }
}
