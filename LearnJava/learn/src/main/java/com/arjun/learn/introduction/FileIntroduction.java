package com.arjun.learn.introduction;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileIntroduction {
    public static void main(String[] args) {

        introduction();

        File file = new File("text.txt");
        try {
            System.out.println(readFileAsString(file.getAbsolutePath()));
        } catch (Exception exception) {
            System.out.println("IO exception reading file: " + file.getAbsolutePath());
        }

        writeFile();
    }

    public static void introduction() {
        // Not necessary the file exists, the following is like a placeholder
        File file = new File("text.txt");

        System.out.println(file.getAbsolutePath());
        System.out.println(file.getName());

        if(file.isDirectory()) {
            System.out.println("Is Directory");
        } else {
            System.out.println("Not a Directory");
        }

        if(file.exists()) {
            System.out.println("FileIntroduction exists");
        } else {
            System.out.println("FileIntroduction does not exist");
        }
    }

    public static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static void writeFile() {
        File file = new File("check.txt");

        // Following automatically closes the file
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("Hello, World");
        } catch (IOException e) {
            System.out.printf("An exception occurs %s", e.getMessage());
        }
    }

    public static void printWriter() {
        File file = new File("check.txt");
        try (PrintWriter printWriter = new PrintWriter(file)) {
            printWriter.print("Hello"); // prints a string
            printWriter.println("Java"); // prints a string and then terminates the line
            printWriter.println(123); // prints a number
            printWriter.printf("You have %d %s", 400, "gold coins"); // prints a formatted string
        } catch (IOException e) {
            System.out.printf("An exception occurs %s", e.getMessage());
        }
    }

    // Example function to obtain all files in a directory and its subdirectories
    public List<File> getAllFiles(File rootDir) {
        File[] children = rootDir.listFiles();
        if (children == null || children.length == 0) {
            return Collections.emptyList();
        }

        List<File> files = new ArrayList<>();
        for (File child : children) {
            if (child.isDirectory()) {
                files.addAll(getAllFiles(child));
            } else {
                files.add(child);
            }
        }

        return files;
    }
}
