package com.arjun.learn.introduction;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Strings {

  public static void main(String[] args) {
    Strings strings = new Strings();

    System.out.println("Strings Introduction");
    strings.introduction();
    System.out.println("--------------------");

    System.out.println("String Initialization");
    strings.waysToInitialise();
    System.out.println("--------------------");

    System.out.println("String Common Methods");
    strings.commonMethods();
    System.out.println("--------------------");

    System.out.println("String Builder Common Methods");
    strings.stringBuilderCommonMethods();
    System.out.println("--------------------");

    System.out.println("String Sort");
    strings.stringSort();
    System.out.println("--------------------");
  }

  public void introduction() {
    // Strings are immutable. Cannot modify the Characters by index
    String simpleString = "It is a simple string"; // a simple string
    System.out.println(simpleString);  // it prints "It is a simple string"

    String anotherString = "This is\na multiple\nstring"; // a string with escape sequences
    System.out.println(anotherString); // it prints the result in several lines

    // strings can be null
    String nullString = null;

    String strangeText = "aaaaaaaaaaaassssssssssss gggggggggggggggggggg ddddddddddd qqqqqq ffff";
    String emptyString = "";
    String s = "s"; // a string consisting of one character

    // Common exceptions in processing strings
    // NullPointerException
    // StringIndexOutOfBoundsException
  }

  public void waysToInitialise() {
    String first = "first";
    System.out.printf("Direct %s%n", first);
    String second = new String("second");
    System.out.printf("Using new %s%n", second);

    char[] charArray = new char[]{'a', 'b', 'c', 'd', 'e', 'f'};
    String third = new String(charArray);
    System.out.printf("From char[] using new %s%n", third);
    String fourth = new String(charArray, 2, 2);
    System.out.printf("From char[] with offset 2 and count 2 %s%n", fourth);
    String fifth = String.valueOf(charArray, 2, 3);
    System.out.printf("From char[] using value of %s%n", fifth);

    Character[] CharacterArray = new Character[]{'a', 'b', 'c'};
    String sixth = Arrays.stream(CharacterArray).map(String::valueOf).collect(Collectors.joining());
    System.out.printf("From Character[] using value of %s%n", sixth);

    // Back to array
    char[] charArrayBack = first.toCharArray();
    System.out.printf("Back to char[] array %s%n", Arrays.toString(charArrayBack));
  }

  public void commonMethods() {
    String name = "Arjun Khera";

    // Basics
    System.out.println("Length :" + name.length()); // 11
    System.out.println("Is length of string 0 ? " + name.isEmpty()); // false
    System.out.println(
        "Is string length 0 or consisting only of spaces and tabs ? " + name.isBlank()); // false

    // Comparing strings
    String first = "first";
    String second = "second";

    String anotherFirst = "first";
    String secondInUpperCase = "SECOND";

    System.out.println(first.equals(second)); // false, the strings have different values
    System.out.println(first.equals(anotherFirst)); // true, the strings have the same value

    System.out.println(second.equals(secondInUpperCase)); // false, the strings have different cases
    System.out.println(second.equalsIgnoreCase(secondInUpperCase)); // true, it ignores cases

    // Find prefix
    boolean flag;
    flag = name.startsWith("Arjun");
    System.out.println("String starts with Arjun ? " + flag);
    flag = name.endsWith("String ends with Khera? " + "Khera");
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

    // Splitting a string
    String testString = "This string has spaces";
    String[] splitString = testString.split(" ");
    for (String i : splitString) {
      System.out.println(i);
    }

    // Index Of
    String testIndex = "abcdefabcdef";
    System.out.printf("First Index of char a %d%n", testIndex.indexOf('a'));
    System.out.printf("First Index of char a starting forwards from 3 is %d%n",
        testIndex.indexOf('a', 3));
    System.out.printf("Last Index of char a %d%n", testIndex.lastIndexOf('a'));
    System.out.printf("Last Index of char a starting backwards from 3 is %d%n",
        testIndex.lastIndexOf('a', 3));

    System.out.printf("First Index of string ab %d%n", testIndex.indexOf("ab"));
    System.out.printf("First Index of string ab starting forwards from 3 is %d%n",
        testIndex.indexOf("ab", 3));
    System.out.printf("Last Index of string ab %d%n", testIndex.lastIndexOf("ab"));
    System.out.printf("Last Index of string ab starting backwards from 3 is %d%n",
        testIndex.lastIndexOf("ab", 3));

    String firstString = "first";
    String secondString = "second";
    System.out.println(firstString.compareTo(secondString));
  }

  public void stringBuilderCommonMethods() {
    String original = "original string";
    String reverse = new StringBuilder(original).reverse().toString();

    System.out.println(original + "::" + reverse);
  }

  public void stringSort() {
    String str = "this is an unsorted string";
    char[] charArr = str.toCharArray();
    Arrays.sort(charArr);
    String sortedStr = String.valueOf(charArr);
  }

  /**
   * Example program for counting spaces
   */
  public void countWhiteSpaces() {
    String str = "strings are not primitive types!";

    int count = 0;
    for (char ch : str.toCharArray()) {
      if (Character.isWhitespace(ch)) {
        count++;
      }
    }

    System.out.println(count); // 4
  }
}
