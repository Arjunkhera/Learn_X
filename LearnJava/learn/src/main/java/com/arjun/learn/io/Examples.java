package com.arjun.learn.io;

import java.util.Arrays;
import java.util.Scanner;

public class Examples {

    public int[] readingIntegersIntoArray() {
        final Scanner scanner = new Scanner(System.in);
        int[] numbers = null;
        if (scanner.hasNextInt()) {
            numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        return numbers;
    }
}
