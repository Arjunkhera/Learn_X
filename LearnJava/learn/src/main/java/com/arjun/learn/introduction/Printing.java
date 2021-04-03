package com.arjun.introduction;

import java.util.Scanner;

public class Printing {
    public static void main(String[] args) {

        printing();
        System.out.println("--------");

        readingInput();
        System.out.println("--------");

        comments();
        System.out.println("--------");
        
    }

    public static void printing() {
        // Print with a newline at the end
        System.out.println("Hello World");

        // Print without a newline
        System.out.print("first ");
        System.out.print("second ");
        System.out.println("");
    }

    public static void readingInput() {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        System.out.println(line);

        int number = scanner.nextInt();
        System.out.println(number);

        double decimalNumber = scanner.nextDouble();
        System.out.println(decimalNumber);

        String string = scanner.next();
        System.out.println(string);
    }

    /**
     * Example of Javadoc comments
     */
    public static void comments() {
        System.out.println("Section on comments");

        // Single line comments

        /*
        Multi
        Line
        Comments
         */
    }
}

