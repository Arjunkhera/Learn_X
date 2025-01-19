package com.arjun.learn.introduction;

import java.util.Arrays;

public class NumericLiterals {

    public void convertNumberToString() {
        // Inbuilt functions : leading zeros are never printed
        int n = 13;
        System.out.println("Integer to Octal: " + Integer.toString(n,8)); // decimal to octal
        System.out.println("Integer to Binary: " + Integer.toString(n,2)); // decimal to binary
        System.out.println("Integer to Hexadecimal: " + Integer.toString(n,16)); // decimal to Hex

        // Negative numbers are interpreted as unsigned with a separate negative sign
        System.out.println("Negative Integer to Binary: " + Integer.toString(-13,2));

        // Or directly specify the base in function call
        System.out.println("Integer to Binary direct method: " + Integer.toBinaryString(n));
        // Here, negative number are represented in signed form
        // Which means two's complement for negative numbers
        System.out.println("Negative Integer to Binary direct method: " + Integer.toBinaryString(-13));
        System.out.println("Negative Integer to Hexadecimal direct method: " + Integer.toHexString(-13));
    }

    public void convertingStringToNumber() {
        // For positive numbers
        System.out.println("Octal to Integer: " + Integer.parseInt("15", 8));
        System.out.println("Binary to Integer: " + Integer.parseInt("1101", 2));
        System.out.println("Hexadecimal to Integer: " + Integer.parseInt("d", 16));

        // For negative numbers
        // Takes int values with sign.
        // Passing a negative signed value would give NumberFormatException due to overflow
        // Use this when converting back from Integer.toString(, base=2);
        System.out.println("Binary to Integer with sign: " + Integer.parseInt("-1101", 2));
        // Take in binary signed representation and returns the int value.
        // Use this when converting back from toBinaryString or variants
        System.out.println("Binary to Integer without sign: " + Integer.parseUnsignedInt("11111111111111111111111111110011", 2));
    }

    public void backAndForth() {
        // Gives magnitude in binary along with sign for negative values
        System.out.println(Integer.toString(-1,2)); // -1
        // Give the int value of binary representation along with sign
        System.out.println(Integer.parseInt(Integer.toString(-1, 2),2)); // -1

        // Gives signed binary representation of input value
        System.out.println(Integer.toBinaryString(-1)); // 11111111111111111111111111111111
        // Gives the integer value of signed binary number
        System.out.println(Integer.parseUnsignedInt(Integer.toBinaryString(-1), 2)); // -1

    }

    public void getBinaryArrayFromNumber(int number) {
        int[] arr = new int[Integer.SIZE];
        int j = Integer.SIZE - 1;

        // j >= 0 if for cases when the number is negative
        // since negative numbers are stored in two's complement
        while(number != 0 && j >= 0) {
            arr[j--] = number & 1;
            number >>= 1;
        }

        System.out.println(Arrays.toString(arr));
    }
}
