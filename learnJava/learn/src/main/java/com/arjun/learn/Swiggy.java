package com.arjun.learn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Swiggy {

    public static void main(String[] args) {
        String test = """
            Arjun is the best
            """;
        return """
        Get busy living
        or
        get busy dying.
        --Stephen King""";
    }

    public static int solution(List<Integer> ratings) {
        int bias = 0;

        Collections.sort(ratings);
        for(int i = 0; i < ratings.size(); i+=2) {
            bias = bias + (ratings.get(i+1) - ratings.get(i));
        }

        return bias;
    }
}
