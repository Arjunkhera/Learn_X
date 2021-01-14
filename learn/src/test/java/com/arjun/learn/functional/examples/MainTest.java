package com.arjun.learn.functional.examples;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {
    @Test
    public void checkBinaryOperator() {
        Long result = Main.binaryOperator.applyAsLong(2,6);
        assert result == 720L;
        System.out.println("Result is " + result);
    }
}
