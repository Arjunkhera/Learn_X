package com.arjun.inputoutput;

import java.io.*;
import java.util.Arrays;

public class OutputStreamIntroduction {
    public static void main(String[] args) {
        try {
//            charArrayWriter();
//            byteStreamIntroduction();
//
//            exampleFirst();
            exampleSecond();
            // converting string to byte array
            String str = "stream";
            byte[] strAsBytes = str.getBytes();
        } catch (Exception exception) {
            exception.toString();
        }
    }

    public static void charArrayWriter() throws IOException {
        CharArrayWriter contactWriter = new CharArrayWriter();
        contactWriter.write("Phone: 111-222-333; Address: Java Avenue, 7");

        char[] array = contactWriter.toCharArray();
        System.out.println(contactWriter.toString());
        contactWriter.close();
    }

    public static void byteStreamIntroduction() throws IOException {
        byte[] data = new byte[] {'s', 't', 'r', 'e', 'a', 'm'};
        // will create a file if not present
        // remember file is always created at root level of project
        OutputStream outputStream = new FileOutputStream("sample.txt", false);
        outputStream.write(data);
        outputStream.close();
    }

    public static void exampleFirst() {
        String[] words = new String[] {"first", "second"};
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        Arrays.stream(words).forEach(word -> charArrayWriter.write(word, 0, word.length()));
        System.out.println(charArrayWriter.toString());
    }

    public static void exampleSecond() {
        File sampleFile = new File("sample.txt");
        byte[] content = new byte[] {'J', 'a', 'v', 'a'};

        try {
            OutputStream outputStream = new FileOutputStream(sampleFile, true);
            outputStream.write(content);
            outputStream.close();
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }
}
