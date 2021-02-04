package com.arjun.learn.algorithms.dynamicprogramming;

import java.util.Arrays;

public class CoinChange {
    private final int[] coins;

    public CoinChange(int[] coins) {
        this.coins = coins;
    }

    public int tabulate(int amount) {
        if(coins == null || coins.length == 0) return -1;
        if(amount == 0) return 0;

        int n = coins.length;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for(int i = 1; i <= amount; i++)
            for(int coin : coins)
                if(coin <= i)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                else
                    break;

        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}
