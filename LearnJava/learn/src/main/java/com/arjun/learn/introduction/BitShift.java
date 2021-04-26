package com.arjun.learn.introduction;

import java.util.Arrays;

public class BitShift {

    public static void main(String[] args) {
        convertNumberToString();
        System.out.println("-------");

        // convertingStringToNumber();
        System.out.println("-------");

        getBinaryArrayFromNumber(13);
        System.out.println("-------");

        getBinaryArrayFromNumber(-13);
        System.out.println("-------");
    }

    public static void convertNumberToString() {
        // Inbuilt functions : leading zeros are never printed
        int n = 13;
        System.out.println(Integer.toString(n,8)); // decimal to octal
        System.out.println(Integer.toString(n,2)); // decimal to binary
        System.out.println(Integer.toString(n,16)); // decimal to Hex

        // Negative numbers are interpreted as unsigned with a separate negative sign
        System.out.println(Integer.toString(-13,2));

        // Or directly specify the base in function call
        System.out.println(Integer.toBinaryString(n));
        // Here, negative number are represented in signed form
        // Which means two's complement for negative numbers
        System.out.println(Integer.toBinaryString(-13));
        System.out.println(Integer.toHexString(-13));
    }

    public static void convertingStringToNumber() {
        // For positive numbers
        System.out.println(Integer.parseInt("15", 8));
        System.out.println(Integer.parseInt("1101", 2));
        System.out.println(Integer.parseInt("d", 16));

        // For negative numbers
        System.out.println(Integer.parseInt("11111111111111111111111111110011", 2));
    }

    public static void getBinaryArrayFromNumber(int number) {
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
