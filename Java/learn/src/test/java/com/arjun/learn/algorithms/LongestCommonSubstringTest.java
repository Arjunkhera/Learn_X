package com.arjun.learn.algorithms;

import com.arjun.learn.algorithms.dynamicprogramming.LongestCommonSubstring;
import org.junit.jupiter.api.Test;

public class LongestCommonSubstringTest {

    @Test
    public void first() {
        LongestCommonSubstring longestCommonSubstring = new LongestCommonSubstring();
        String a = "zxabcdezy";
        String b = "yzabcdezx";

        String answer = longestCommonSubstring.longestCommonSubstring(a, b);
        assert answer.equals("abcdez");
    }

    @Test
    public void second() {
        LongestCommonSubstring longestCommonSubstring = new LongestCommonSubstring();
        String a = "zxabcdezy";
        String b = "yzabcdezx";

        String answer = longestCommonSubstring.spaceOptimized(a, b);
        assert answer.equals("abcdez");
    }

}
