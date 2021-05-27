package com.arjun.learn.algorithms.dynamicprogramming;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n+1][m+1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                if(text1.charAt(i-1) == text2.charAt(j-1))
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]+1);
            }
        }

        return dp[n][m];
    }

    public int spaceOptimizedBottomUp(String text1, String text2) {
        int n = text1.length(), m = text2.length(), prev, temp;
        int[] dp = new int[m+1];

        for(int i = 0; i < n; i++) {
            prev = 0;

            for(int j = 1; j <= m; j++) {
                temp = dp[j];
                dp[j] = Math.max(dp[j], dp[j-1]);
                if(text1.charAt(i) == text2.charAt(j-1))
                    dp[j] = Math.max(dp[j], prev+1);
                prev = temp;
            }
        }

        return dp[m];
    }

    public int memoization(String a, String b) {
        int[][] dp = new int[a.length()][b.length()];
        for(int[] arr:dp)
            Arrays.fill(arr, -1);
        return dpRecursion(a, a.length()-1, b, b.length()-1, dp);
    }

    public int dpRecursion(String a, int i, String b, int j, int[][] dp) {
        if(i < 0 || j < 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int answer = Math.max(dpRecursion(a, i-1, b, j, dp), dpRecursion(a, i, b, j-1, dp));
        if(a.charAt(i) == b.charAt(j))
            answer = Math.max(answer, dpRecursion(a, i-1, b, j-1, dp)+1);

        dp[i][j] = answer;
        return answer;
    }

    public int recursive(String a, String b) {
        return solve(a, a.length()-1, b, b.length()-1, 0);
    }

    public int solve(String a, int i, String b, int j, int len) {
        if(i < 0 || j < 0) return len;

        int answer = Math.max(solve(a, i-1, b, j, len), solve(a, i, b, j-1, len));
        if(a.charAt(i) == b.charAt(j))
            answer = Math.max(answer, solve(a, i-1, b, j-1, len+1));
        return answer;
    }
}
