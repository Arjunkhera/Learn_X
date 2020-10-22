package com.arjun.encryption;

import java.util.Scanner;

public class second {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        int key = scanner.nextInt();

        System.out.println(secondEncryption(message, key));
    }

    public static String secondEncryption(String message, int key) {
        String cipherText = "";

        for (int i = 0; i < message.length(); i++) {
            if (Character.isAlphabetic(message.charAt(i))) {
                System.out.println(message.charAt(i) - 'a');
                cipherText += Character.toString('a' + (((message.charAt(i) - 'a') + key) % 26));
            } else {
                cipherText += message.charAt(i);
            }
        }

        return cipherText;
    }
}
