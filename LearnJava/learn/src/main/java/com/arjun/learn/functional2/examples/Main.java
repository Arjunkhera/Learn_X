package com.arjun.learn.functional.examples;

import java.util.function.LongBinaryOperator;
import java.util.stream.LongStream;

public class Main {

    public static LongBinaryOperator binaryOperator = (left, right) -> LongStream
            .rangeClosed(left, right)
            .reduce((i, j) -> i * j)
            .orElse(0);
}
