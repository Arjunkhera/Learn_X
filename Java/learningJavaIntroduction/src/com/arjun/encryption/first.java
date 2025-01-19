package com.arjun.encryption;

public class first {
    public static void main(String[] args) {
        System.out.println(firstEncryption("we found a treasure!"));
    }

    public static String firstEncryption(String plainText) {
        String cipherText = "";

        for (int i = 0; i < plainText.length(); i++) {
            if (plainText.charAt(i) == ' ' || plainText.charAt(i) == '!') {
                cipherText += plainText.charAt(i);
            } else {
                cipherText += Character.toString((char)'z' - (plainText.charAt(i) - 'a'));
            }
        }

        return cipherText;
    }
}
