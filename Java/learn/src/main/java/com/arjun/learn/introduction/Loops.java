package com.arjun.learn.introduction;

import java.util.Scanner;

public class Loops {

    public static void main(String[] args){

        introduction();
        System.out.println("---------");

        exampleCode();
        System.out.println("---------");
    }

    public static void introduction() {
        // for (initialization; condition; modification) {
             // do something
        // }
        // Here is how the code flows
        // --------------------------
        // the initialization statement
        // if the condition is false then terminate the loop;
        // if the condition is true, then loop's body is executed;
        // the modification is performed;
        // go to the stage 2 (condition).

        // finding the sum of first ten numbers
        int startIncl = 1, endExcl = 11;

        int sum = 0;
        for (int i = startIncl; i < endExcl; i++) {
            sum += i;
        }

        System.out.println(sum);

        // while loop
        int i = 0;
        while (i < 5) {
            System.out.println(i);
            i++;
        }

        // do while loop
        Scanner scanner = new Scanner(System.in);

        int value;
        do {
            value = scanner.nextInt();
            System.out.println(value);
        } while (value > 0);


    }

    public static void exampleCode() {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        while (scanner.hasNext()) {
            int elem = scanner.nextInt();
            sum += elem;
        }

        System.out.println(sum);
    }
}
