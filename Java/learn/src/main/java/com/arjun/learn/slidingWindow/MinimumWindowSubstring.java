package com.arjun.grokking.slidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        String pattern = scanner.nextLine();
        // System.out.println(findSubstring(str, pattern));
        System.out.println(findSecond(str, pattern));
    }

    public static String findSubstring(String str, String pattern) {
        String result = "";
        if(str.isEmpty() || pattern.isEmpty() || pattern.length() > str.length()) return result;

        Map<Character, Integer> store = new HashMap<>();
        pattern.chars().
                forEach(ch -> store.put((char) ch, store.getOrDefault((char)ch, 0) + 1));
        
        int length = Integer.MAX_VALUE;
        int startIndex = 0;
        int matched = 0;
        Map<Character, Integer> frequency = new HashMap<>();

        for(int endIndex = 0; endIndex < str.length(); endIndex++) {
            char rightChar = str.charAt(endIndex);
            frequency.put(rightChar, frequency.getOrDefault(rightChar, 0) + 1);
            if(store.containsKey(rightChar) && store.get(rightChar).equals(frequency.get(rightChar))) {
                matched += 1;
            }

            while(matched == store.size()) {
                if(endIndex - startIndex + 1 < length) {
                    length = endIndex - startIndex + 1;
                    result = str.substring(startIndex, endIndex + 1);
                }

                char leftChar = str.charAt(startIndex++);
                frequency.put(leftChar, frequency.get(leftChar) - 1);
                if(store.containsKey(leftChar) && frequency.get(leftChar) < store.get(leftChar)) {
                    matched -= 1;
                }
            }
        }

        return result;
    }

    public static String findSecond(String str, String pattern) {
        int windowStart = 0, matched = 0, minLength = str.length() + 1, subStrStart = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : pattern.toCharArray())
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);

        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (charFrequencyMap.containsKey(rightChar)) {
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
                if (charFrequencyMap.get(rightChar) >= 0) // count every matching of a character
                    matched++;
            }

            // shrink the window if we can, finish as soon as we remove a matched character
            while (matched == pattern.length()) {
                if (minLength > windowEnd - windowStart + 1) {
                    minLength = windowEnd - windowStart + 1;
                    subStrStart = windowStart;
                }

                char leftChar = str.charAt(windowStart++);
                if (charFrequencyMap.containsKey(leftChar)) {
                    // note that we could have redundant matching characters, therefore we'll decrement the
                    // matched count only when a useful occurrence of a matched character is going out of the window
                    if (charFrequencyMap.get(leftChar) == 0)
                        matched--;
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
                }
            }
        }

        return minLength > str.length() ? "" : str.substring(subStrStart, subStrStart + minLength);
    }
}
