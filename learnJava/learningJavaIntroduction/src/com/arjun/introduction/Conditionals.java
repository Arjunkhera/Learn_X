package com.arjun.introduction;

public class Conditionals {

    public static void main(String[] args){
        introduction();
        System.out.println("-------");
    }

    public static void introduction() {
        int num = 7; // the num is initialized by some value

        if (num % 2 == 0) {
            System.out.println("It's an even number");
        } else {
            System.out.println("It's an odd number");
        }

        long dollars = 1200;

        if (dollars < 1000) {
            System.out.println("Buy a laptop");
        } else if (dollars < 2000) {
            System.out.println("Buy a personal computer");
        } else if (dollars < 100_000) {
            System.out.println("Buy a server");
        } else {
            System.out.println("Buy a data center or a quantum computer");
        }
    }
}
