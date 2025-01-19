package com.arjun.functional.examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Miscellaneous {
    private static Stream<String> detectWordsFromList(String text,
                                                      List<String> badWords) {
        return Arrays.stream(text.split(" ")).filter(badWords::contains).distinct();
    }

}
