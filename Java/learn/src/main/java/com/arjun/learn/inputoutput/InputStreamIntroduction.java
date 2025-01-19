package com.arjun.learn.inputoutput;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class InputStreamIntroduction {
    public static void main(String[] args) {
        try {
            inputStreamChar();
            inputStreamByte();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void inputStreamChar() throws IOException {
        Reader reader = null;

        try {
            reader = new FileReader("text.txt");

            char first = (char) reader.read();
            char second = (char) reader.read();

            System.out.println("First : " + first);
            System.out.println("Second : " + second);

            // Reading the complete file in one go
            // End of file reads as -1
            int characterRead = reader.read();
            while(characterRead != -1) {
                System.out.print((char) characterRead);
                characterRead = reader.read();
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            reader.close();
        }
    }

    public static void inputStreamByte() throws IOException {
        try {
            java.io.InputStream inputStream = new FileInputStream("text.txt");

            int currentByte = inputStream.read();
            while(currentByte != -1) {
                System.out.print(currentByte);
                currentByte = inputStream.read();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}
