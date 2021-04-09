package com.arjun.learn.introduction;

public class Characters {

    public static void main(String[] args) {

        introduction();
        System.out.println("-----------");
    }

    public static void introduction() {

        char lowerCaseLetter = 'a';
        char upperCaseLetter = 'Q';
        char number = '1';
        char space = ' ';
        char dollar = '$';
        System.out.println(lowerCaseLetter + " " + upperCaseLetter + " " + number + " " + space + " " + dollar);

        // size of char is 2 bytes or an unsigned integer of range 0 to 65535
        // char be initialised with an integer
        // or unicode : see the javascript notes for more info on unicode and related stuff
        char first = '@';
        char second = '\u0040';
        // both represent the same character
        System.out.println(first + " " + second);

        // we can manipulate character with both int and char itself
        char ch = 'b';
        ch += 1; // 'c'
        ch -= 2; // 'a'
        System.out.println(ch);

        ch = 'b';
        ch += 'a';
        ch -= 'b';
        System.out.println(ch); // prints 'a' without quotes

        // Here are some more manipulations
        ch = 'A';
        ch += 10;
        System.out.println(ch);   // 'K'
        System.out.println(++ch); // 'L'
        System.out.println(++ch); // 'M'
        System.out.println(--ch); // 'L'

        // escape sequences
        System.out.print('\t'); // makes a tab
        System.out.print('a');  // prints 'a'
        System.out.print('\n'); // go to the new line
        System.out.print('c');  // prints 'c'
    }
}
