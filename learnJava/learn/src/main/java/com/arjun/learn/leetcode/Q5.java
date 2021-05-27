package com.arjun.learn.leetcode;

public class Q5 {
    public String longestPalindrome(String s) {
        if (s.length() < 2)
            return s;

        int maxlen = 0, j, k, temp;
        String answer = "";

        for(int i = 0; i < s.length() - 1; i++) {

            j = i-1; k = i+1; temp = 1;
            while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
                j--; k++; temp += 2;
            }
            if(temp > maxlen) {
                maxlen = temp;
                answer = s.substring(j+1, k);
            }

            j = i; k = i+1; temp = 0;
            while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
                j--; k++; temp += 2;
            }
            if(temp > maxlen) {
                maxlen = temp;
                answer = s.substring(j+1, k);
            }
        }

        return answer;
    }
}
