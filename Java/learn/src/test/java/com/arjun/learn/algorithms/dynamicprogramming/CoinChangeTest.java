package com.arjun.learn.algorithms.dynamicprogramming;

import org.junit.jupiter.api.Test;

public class CoinChangeTest {
    @Test
    public void coinTest() {
        CoinChange coinChange;

        coinChange = new CoinChange(new int[]{1,2,5});
        assert coinChange.tabulate(11) == 3;

        coinChange = new CoinChange(new int[]{2});
        assert coinChange.tabulate(3) == -1;

        coinChange = new CoinChange(new int[]{1});
        assert coinChange.tabulate(0) == 0;
        assert coinChange.tabulate(1) == 1;
        assert coinChange.tabulate(2) == 2;
    }
}
