package com.arjun.learn;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class App {
    public static void main( String[] args ) throws IOException {
//        commonStringFunctions();
//        stringAndCharacters();
//        Map<Character, Integer> store = new HashMap<>();
//        char first = ':';
//        char second = 'a';
//        System.out.println(Character.isLetterOrDigit(first));
//        System.out.println(Character.isLetterOrDigit(second));

        testing();
    }

    public static void commonStringFunctions() {
        String name = "Arjun Khera";

        // Basics
        System.out.println("Length :" + name.length()); // 11
        System.out.println("Is length of string 0 ? " + name.isEmpty()); // false
        System.out.println("Is string length 0 or consisting only of spaces and tabs ? " + name.isBlank()); // false

        // Find prefix
        boolean flag;
        flag = name.startsWith("Arjun");
        System.out.println("String starts with Arjun ? " + flag);
        flag = name.endsWith("String ends with Srivastava ? " + "Srivastava");
        System.out.println(flag);

        // Obtaining a substring
        String firstName = name.substring(0, "Arjun".length());
        System.out.println("First name is :" + firstName);
        String lastName = name.substring("Arjun".length() + 1);
        System.out.println("Last name is :" + lastName);

        // Changing case
        System.out.println(name.toUpperCase());
        System.out.println(name.toLowerCase());


        String path = "/content/help/en/language/en/men/products";

        // Replaces all occurrences
        String newPath = path.replace("/en/", "/fr/");
        System.out.println("Original Path : " + path);
        System.out.println("Modified Path : " + newPath);

        // Replace all given regex
        String replaceAll = path.replaceAll("/", "|");
        System.out.println("Replace all : " + replaceAll);

        // Replace first given regex
        String replaceFirst = path.replaceFirst("/en/", "/fr/");
        System.out.println("Replace first : " + replaceFirst);
    }

    public static void stringAndCharacters() {
        String str = "This is a String";

        // Get a char given index
        System.out.println(str.charAt(1));

        // Converting character arrays to String
        char[] charArray = new char[]{'1', '2', '3'};

        // Two ways
        String convertedStringFirst = String.valueOf(charArray);
        System.out.println("First conversion method : " + convertedStringFirst);
        String convertedStringSecond = new String(charArray);
        System.out.println("Second conversion method : " + convertedStringSecond);

        Character[] CharacterArray = new Character[]{'1', '2', '3'};
        String convertedStringThird = CharacterArray.toString();
        System.out.println("Third conversion method : " + convertedStringThird);
    }

    public static void testing() {
        int[] first = new int[3];

        int[] second = new int[first];

    }
}
