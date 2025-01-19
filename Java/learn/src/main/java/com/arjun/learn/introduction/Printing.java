package com.arjun.learn.introduction;

import java.util.Locale;

public class Printing {

  public void unformattedPrinting() {
    // Print with a newline at the end
    System.out.println("Hello World");

    // Print without a newline
    System.out.print("first ");
    System.out.print("second ");
    System.out.println("");
  }

  public void formattedOutputPrintf() {
    /*
    Following two signatures are used for formatted outputs
        System.out.printf(format, arguments);
        System.out.printf(locale, format, arguments);
    */


    /*
      Format Specifier Syntax
      %[flags][width][.precision]conversion-character

      Conversion Characters
        s formats strings.
        d formats decimal integers.
        f formats floating-point numbers.
        t formats date/time values.
    */

    // Booleans
    System.out.println("Booleans");
    System.out.printf("%b%n", null);
    System.out.printf("%B%n", false);
    System.out.printf("%B%n", 5.3);
    System.out.printf("%b%n", "random text");

    // Strings
    System.out.println("Strings");
    String firstName = "Arjun", lastName = "Khera";
    // Use capital format specifier for Upper Case output
    System.out.printf("First Name:[%s], Last Name:[%S]%n", firstName, lastName);
    // We can specify character padding through width
    // Padding is by default on left size
    // Length of padding is size of argument minus provided length
    System.out.printf("%3s%n", firstName); // zero padding since 3 < 5
    System.out.printf("%7s%n", firstName); // padding of two on left
    System.out.printf("%-7s %s%n", firstName, lastName); // padding of two on right
    // Control length of string using precision
    System.out.printf("%7.3s%n", firstName); // padding of four on left and 3 chars from string

    // Characters
    System.out.println("Characters");
    System.out.printf("%c%n", 's');
    System.out.printf("%C%n", 's');

    // Integers
    System.out.println("Integers");
    System.out.printf("simple integer: %d%n", 10000L);
    System.out.printf(Locale.US, "%,d %n", 10000);
    System.out.printf(Locale.ITALY, "%,d %n", 10000);

    // Float and Double
    System.out.println("Floating Numbers");
    System.out.printf("'%5.2f'%n", 5.1473);
  }
}

