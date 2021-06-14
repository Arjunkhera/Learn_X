package com.arjun.learn.algorithms.dynamicprogramming;

import org.junit.jupiter.api.Test;

import java.util.Objects;

public class LongestCommonSubstringTest {

    @Test
    public void lcsTest() {
        String first = "abcdxyz";
        String second = "xyzabcd";

        assert Objects.equals(LongestCommonSubstring.longestCommonSubstring(first, second), "abcd");
    }

    @Test
    public void spaceOptimizedTest() {
        String first = "abcdxyz";
        String second = "xyzabcd";

        assert Objects.equals(LongestCommonSubstring.spaceOptimized(first, second), "abcd");

    }
}
