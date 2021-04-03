package com.arjun.inputoutput;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ReadingInputs {
    public static void main(String[] args) {
        differenceBetweenNextAndNextLine();
    }

    public static void differenceBetweenNextAndNextLine() {
        Scanner scanner = new Scanner(System.in);

        // next reads till next whitespace
        System.out.println(scanner.next());

        // next line reads till end of line
        System.out.println(scanner.nextLine());
    }

    public static void readingIntegers() {
        Scanner scanner = new Scanner(System.in);

        // Ordered stream
        int N = 10;
        int[] numbersFirst = IntStream.range(0, N).map(i -> scanner.nextInt()).toArray();

        // Unordered stream
        int[] numbersSecond = IntStream.generate(scanner::nextInt).limit(N).toArray();
    }

}
