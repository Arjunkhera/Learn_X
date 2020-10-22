package com.arjun.encryption;

import java.util.Scanner;

public class third {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String task = scanner.nextLine();
        String message = scanner.nextLine();
        int key = scanner.nextInt();
        String result = "Invalid Options";

        if (task.equals("enc")) {
            result = encryption(message, key);
        } else if (task.equals("dec")) {
            result = decryption(message, key);
        }

        System.out.println(result);
    }

    public static String encryption(String message, int key) {
        String cipherText = "";

        for (int i = 0; i < message.length(); i++) {
            cipherText += Character.toString(message.charAt(i) + key);
        }

        return cipherText;
    }

    public static String decryption(String cipherText, int key) {
        String plainText = "";

        for (int i = 0; i < cipherText.length(); i++) {
            plainText += Character.toString(cipherText.charAt(i) - key);
        }

        return plainText;
    }
}
