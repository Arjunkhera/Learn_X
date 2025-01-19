package com.arjun.learn.functional.examples;

import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    public void checkBinaryOperator() {
        Long result = com.arjun.learn.functional.examples.Main.binaryOperator.applyAsLong(2,6);
        assert result == 720L;
        System.out.println("Result is " + result);
    }
}
