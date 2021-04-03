package com.arjun.introduction;

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
        String testString = "testing 123";

        System.out.println("Length of string : " + testString.length());
        System.out.println("Character at index : " + testString.charAt(3));

        String anotherTestString = "abc def ghi";

        System.out.println(anotherTestString.isEmpty());

        System.out.println(anotherTestString.toUpperCase());
        System.out.println(anotherTestString.toLowerCase());

        System.out.println(anotherTestString.startsWith("abc"));
        System.out.println(anotherTestString.endsWith("gh"));

        System.out.println(anotherTestString.contains("def"));
        System.out.println(anotherTestString.substring(3,7));
        System.out.println(anotherTestString.replace("de","yz"));
    }

    public static void stringsAndChars() {
        char[] charArray = {'A','B','C'};

        // convert character array to string
        String stringFromCharArray = String.valueOf(charArray);
        String anotherMethod = new String(charArray);
        System.out.println(stringFromCharArray);
        System.out.println(anotherMethod);

        // converting string back to char array
        char[] newCharArray = stringFromCharArray.toCharArray();

        // splitting a string
        String testString = "This string has spaces";
        String[] splitString = testString.split(" ");
        for( String i : splitString) {
            System.out.println(i);
        }

        // Example program for counting spaces
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
