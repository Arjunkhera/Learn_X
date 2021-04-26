package com.arjun.introduction;

import java.util.Scanner;

public class Operations {
    public static void main(String[] args) {

        introduction();
        System.out.println("--------");

        simpleArithmetic();
        System.out.println("--------");

        logicalOperations();
        System.out.println("--------");

        relationalOperators();
        System.out.println("--------");
    }

    public static void introduction() {
        // can be stored this way for better visibility
        int numWithUnderscore = 1_00_000;
        System.out.println(numWithUnderscore);

        // number is considered long only if it ends with 'l' or 'L'(preferred)
        long testingLongValue = 23L;
        System.out.println(testingLongValue);
    }

    public static void simpleArithmetic() {

        // Simple operations
        System.out.println(2+3);
        System.out.println(7-3);
        System.out.println(2*3);
        System.out.println(10/2);

    }

    public static void logicalOperations() {
        boolean f = false; // f is false
        boolean t = !f;    // t is true
        System.out.println(f + " " + t);

        boolean b1 = false && false; // false
        boolean b2 = false && true;  // false
        boolean b3 = true && false;  // false
        boolean b4 = true && true;   // true
        System.out.println(b1 + " " + b2 + " " + b3 + " " + b4);

        b1 = false || false; // false
        b2 = false || true;  // true
        b3 = true || false;  // true
        b4 = true || true;   // true
        System.out.println(b1 + " " + b2 + " " + b3 + " " + b4);

        b1 = false ^ false; // false
        b2 = false ^ true;  // true
        b3 = true ^ false;  // true
        b4 = true ^ true;   // false
        System.out.println(b1 + " " + b2 + " " + b3 + " " + b4);
    }

    public static void relationalOperators() {
        int one = 1;
        int two = 2;
        int three = 3;
        int four = 4;

        boolean oneIsOne = one == one; // true
        System.out.println(oneIsOne);

        boolean res1 = two <= three; // true
        boolean res2 = two != four;  // true
        boolean res3 = two > four;   // false
        boolean res4 = one == three; // false
        System.out.println(res1 + " " + res2 + " " + res3 + " " + res4);
    }
}
