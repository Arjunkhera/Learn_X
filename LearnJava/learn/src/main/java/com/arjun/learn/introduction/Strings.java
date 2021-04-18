package com.arjun.learn.introduction;

public class Strings {

    public static void main(String[] args) {

        introduction();
        System.out.println("-----------");

        commonMethods();
        System.out.println("-----------");

        stringsAndChars();
        System.out.println("-----------");
    }

    public static void introduction() {
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

        // Comparing strings
        String first = "first";
        String second = "second";

        String anotherFirst = "first";
        String secondInUpperCase = "SECOND";

        System.out.println(first.equals(second)); // false, the strings have different values
        System.out.println(first.equals(anotherFirst)); // true, the strings have the same value

        System.out.println(second.equals(secondInUpperCase)); // false, the strings have different cases
        System.out.println(second.equalsIgnoreCase(secondInUpperCase)); // true, it ignores cases
    }

    public static void commonMethods() {
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

    public static void stringsAndChars() {
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

        // converting string back to char array
        char[] newCharArray = convertedStringFirst.toCharArray();

        // splitting a string
        String testString = "This string has spaces";
        String[] splitString = testString.split(" ");
        for( String i : splitString) {
            System.out.println(i);
        }
    }

    /**
     * Example program for counting spaces
     */
    public static void countWhiteSpaces() {
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
