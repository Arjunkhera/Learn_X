package com.arjun.learn.algorithms.dynamicprogramming;

import org.junit.Test;

public class FibonacciTest {
    @Test
    public void solve() {
        Fibonacci fibonacci = new Fibonacci();

        int tabulate = fibonacci.tabulate(5);
        int memoize = fibonacci.memoize(5);

        assert tabulate == 5 : "Check if calculate output is correct";
        assert tabulate == memoize : "Check if memoization and tabulation results are same";
    }
}
