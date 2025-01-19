package com.arjun.grokking.slidingWindow;

import java.util.*;
import java.util.stream.Stream;

public class ConcatenatedWords {
    public static List<Integer> findWordConcatenation(String str, String[] words) {
        ArrayList<Integer> result = new ArrayList<>();
        if(str.isEmpty() || words.length == 0) return result;

        Map<String, Integer> store = new HashMap<>();
        Arrays.stream(words).forEach(word -> store.put(word, store.getOrDefault(word, 0) + 1));

        int numberOfWords = words.length;
        int wordLength = words[0].length();
        int j;

        for(int i = 0; i <= str.length() - numberOfWords * wordLength; i++) {
            Map<String, Integer> current = new HashMap<>();
            j = 0;
            while(j < numberOfWords) {
                int startIndex = i + j * wordLength;
                String checkWord = str.substring(startIndex, startIndex + wordLength);
                if(!store.containsKey(checkWord)) break;

                current.put(checkWord, current.getOrDefault(checkWord, 0) + 1);
                if(current.get(checkWord) > store.getOrDefault(checkWord, 0)) break;

                j += 1;
            }

            if(j == numberOfWords) result.add(i);
        }

        return result;
    }
}
