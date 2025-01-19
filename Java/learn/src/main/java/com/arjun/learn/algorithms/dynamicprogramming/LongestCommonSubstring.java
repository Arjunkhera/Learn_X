package com.arjun.learn.algorithms.dynamicprogramming;

public class LongestCommonSubstring {
    public static String longestCommonSubstring(String a, String b) {
        int n = a.length(), m = b.length();
        int[][] dp = new int[n+1][m+1];

        int end = n, maxLen = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= m; j++) {
                if(a.charAt(i-1) == b.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                if(dp[i][j] > maxLen) {
                    maxLen = dp[i][j];
                    end = i;
                }
            }

        return maxLen == Integer.MIN_VALUE ? null : a.substring(end - maxLen, end);
    }

    public static String spaceOptimized(String a, String b) {
        int n = a.length(), m = b.length();
        int[] dp = new int[m+1];

        int end = n, maxLen = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++)
            for(int j = m; j > 0; j--) {
                dp[j] = a.charAt(i-1) == b.charAt(j-1) ? dp[j-1] + 1 : 0;
                if(dp[j] > maxLen) {
                    maxLen = dp[j];
                    end = i;
                }
            }

        return maxLen == Integer.MIN_VALUE ? null : a.substring(end - maxLen, end);
    }
}
