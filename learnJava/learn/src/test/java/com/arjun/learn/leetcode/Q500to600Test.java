package com.arjun.learn.leetcode;

import org.junit.jupiter.api.Test;

public class Q500to600Test {

    @Test
    public void Q500Test() {
        Q516 longestPalindromeSubsequence = new Q516();

        int answer = longestPalindromeSubsequence.longestPalindromeSubsequence("bbbab");
        assert answer == 4;
    }
}
