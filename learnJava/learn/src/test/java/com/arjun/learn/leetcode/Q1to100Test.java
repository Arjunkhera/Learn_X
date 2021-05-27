package com.arjun.learn.leetcode;

import org.junit.Test;

public class Q1to100Test {
    @Test
    public void bruteforce() {
        Q5 longestPalidromeString = new Q5();
        String a = "babad";

        String answer = longestPalidromeString.longestPalindrome(a);
        assert answer.equals("bab");
    }
}
