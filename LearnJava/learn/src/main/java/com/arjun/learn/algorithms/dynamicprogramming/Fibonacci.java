package com.arjun.learn.algorithms.dynamicprogramming;

public class Fibonacci {
    public int tabulate(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0; dp[1] = 1;

        for(int i = 2; i <= n; i++)
            dp[i] = dp[i-1] + dp[i-2];
        return dp[n];
    }

    public int memoize(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0; dp[1] = 1;

        return solve(dp, n);
    }

    private int solve(int[] dp, int n) {
        if(n < 2 || dp[n] > 0) return dp[n];
        return dp[n] = solve(dp, n-1) + solve(dp, n-2);
    }
}
