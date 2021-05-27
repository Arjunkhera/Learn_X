package com.arjun.learn.leetcode;

import com.arjun.learn.algorithms.dynamicprogramming.LongestCommonSubstring;
import org.junit.Test;

public class Q1143Test {
    @Test
    public void bruteforce() {
        Q1143 longestCommonSubsequence = new Q1143();
        String a = "abcde";
        String b = "ace";

        int answer = longestCommonSubsequence.recursive(a, b);
        assert answer == 3;
    }

    @Test
    public void memoization() {
        Q1143 longestCommonSubsequence = new Q1143();
        String a = "abcde";
        String b = "ace";

        int answer = longestCommonSubsequence.memoization(a, b);
        assert answer == 3;
    }

    @Test
    public void bottomUp() {
        Q1143 longestCommonSubsequence = new Q1143();
        String a = "abcde";
        String b = "ace";

        int answer = longestCommonSubsequence.longestCommonSubsequence(a, b);
        assert answer == 3;
    }

}
