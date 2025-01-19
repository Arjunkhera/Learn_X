package com.arjun.functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class Currying {
    public static void main(String[] args) {
        returningFunctions();
        IntFunction<Integer> integerIntFunction;
    }

    public static void returningFunctions() {
        System.out.println(sum().applyAsInt(3,4));
        System.out.println(sumOfSquares(x -> x*x).applyAsInt(3,4));
        
        // currying sum of squares
        Function<IntUnaryOperator, IntBinaryOperator> curriedSumOfSquares = f -> (a,b) -> f.applyAsInt(a) + f.applyAsInt(b);
        IntBinaryOperator intBinaryOperator = curriedSumOfSquares.apply(x -> x*x);
        System.out.println(intBinaryOperator.applyAsInt(3,4));
    }

    public static IntBinaryOperator sum() {
        return (a, b) -> a + b;
    }

    public static IntBinaryOperator sumOfSquares(IntUnaryOperator f) {
        return (a, b) -> f.applyAsInt(a) + f.applyAsInt(b);
    }

    public static void curryingExample() {
        Function<String, Consumer<String>> say = what -> who -> System.out.println(what + ", " + who);

        List<String> friends = Arrays.asList("John", "Neal", "Natasha");
        Consumer<String> sayHi = say.apply("Hi");
        friends.forEach(sayHi);

        List<String> partners = Arrays.asList("Randolph Singleton", "Jessie James");
        Consumer<String> sayHello = say.apply("Hello");
        partners.forEach(sayHello);
    }
}
