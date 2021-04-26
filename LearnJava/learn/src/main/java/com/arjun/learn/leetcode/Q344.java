package com.arjun.learn.leetcode;

public class Q344 {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length-1;
        while(i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++; j--;
        }
    }
}
