package com.arjun.inputoutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class FilesIntroduction {

    public static void main(String[] args) {
        // introduction();
        // readingFiles();
        // traversingDirectories();
    }

    public static void introduction() {
        // Note : you begin with root of project as current working directory
        System.out.println("Current working directory is : " + System.getProperty("user.dir"));

        File file = new File("check.txt ");

        System.out.println("File name: " + file.getName());
        System.out.println("File path: " + file.getPath());
        System.out.println("File absolute path: " + file.getAbsolutePath());
        System.out.println("Is file: " + file.isFile());
        System.out.println("Is directory: " + file.isDirectory());
        System.out.println("Exists: " + file.exists());
        System.out.println("Parent path:" + file.getParent());

        // Need to escape backward slash on Windows for path. Not required for linux system
        File byAbsolutePath = new File("C:\\Users\\arkhera\\Desktop\\repositories\\learnJava\\learningJavaIntroduction\\check.txt");
        System.out.println("File absolute path: " + byAbsolutePath.getAbsolutePath());
    }

    public static void readingFiles() {
        File file = new File("check.txt");

        // Try with resources : automatically closes the resource
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                System.out.print(scanner.nextLine() + " ");
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found");
        }

        try {
            System.out.println(readFileAsString("check.txt"));
        } catch (IOException e) {
            System.out.println("Cannot read file: " + e.getMessage());
        }
    }

    // Do this only for small files
    public static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static void traversingDirectories() {
        // get access to current working directory
        File currentDirectory = new File(System.getProperty("user.dir"));
        System.out.println(currentDirectory.getAbsolutePath());
        System.out.println(currentDirectory.getName());
        System.out.println(currentDirectory.isDirectory());

        // list all files in current working directory
        File[] files = currentDirectory.listFiles();
        Arrays.stream(files).forEach(file -> System.out.println(file.getName()));

        File parentDirectory = currentDirectory.getParentFile();
        System.out.println(parentDirectory.getAbsolutePath());
        System.out.println(parentDirectory.getName());
        System.out.println(parentDirectory.isDirectory());
    }
}
