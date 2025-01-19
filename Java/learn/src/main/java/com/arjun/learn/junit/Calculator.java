package com.arjun.learn.junit;

public class Calculator {

    public int multiply(int a, int b) {
        return a * b;
    }

    public void throwExceptionExample(int input) throws IllegalArgumentException {
        if(input > 50)
            throw new IllegalArgumentException("Integer greater than 50");
    }
}