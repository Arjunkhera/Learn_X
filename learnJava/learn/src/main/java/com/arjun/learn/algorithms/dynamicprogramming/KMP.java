package com.arjun.learn.algorithms.dynamicprogramming;

import java.util.Arrays;

public class KMP {
    private String pattern;
    int[] prefix;

    public KMP() {
        pattern = null;
        prefix = null;
    }

    public KMP(String pattern) {
        setPattern(pattern);
    }

    private void populatePrefixArray() {
        prefix[0] = 0;
        int j = 0;

        for(int i = 1; i < pattern.length(); i++)
            if(pattern.charAt(i) == pattern.charAt(j)) {
                prefix[i] = ++j;
            } else {
                j = 0;
            }
    }

    public void setPattern(String newPattern) {
        this.pattern = newPattern;
        this.prefix = new int[newPattern.length()];
        populatePrefixArray();
    }

    public void printPattern() {
        System.out.println(Arrays.toString(this.prefix));
    }

    public int isSubString(String str) {
        int j = 0, i = 0;

        for(; i < str.length() && j < this.pattern.length(); i++) {
            if(str.charAt(i) == this.pattern.charAt(j)) {
                j++;
                continue;
            }

            if(j > 0) {
               j = this.prefix[--j];
               i--;
            }
        }

        return j == this.pattern.length() ? i - this.pattern.length() : -1;
    }
}
