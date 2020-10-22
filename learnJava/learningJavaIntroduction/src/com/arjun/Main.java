package com.arjun;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        testing();
    }

    public static void testing()  {
        String[] arr = "My name is Arjun      Khera   gg".split("\\s+");
        for(String str : arr) {
            System.out.println(str);
        }
    }

    public static void getProductNames() {
        File file = new File("C:\\Users\\arkhera\\Desktop\\stageProductPaths.txt");
        File writeFile = new File("productNames.txt");

        try(Scanner scanner = new Scanner(file)){
            PrintWriter printWriter = new PrintWriter(writeFile);

            while(scanner.hasNextLine()) {
                String productName = "";
                String line = scanner.nextLine();
                int matchIndex = line.lastIndexOf("/en/") + "/en/".length();
                int secondMatch = line.indexOf(",", matchIndex);
                System.out.println(line.substring(matchIndex,secondMatch));
                printWriter.println(line.substring(matchIndex,secondMatch));
            }

            printWriter.close();
        } catch (Exception exception) {
                System.out.println("Error reading the file");
        }
    }

    public static int[] sort(int[] inputArray) {
        int i = 1;
        while(i < inputArray.length) {
            int j = i;
            while(j > 0) {
                if(inputArray[j] < inputArray[j-1]) {
                    int temp = inputArray[j];
                    inputArray[j] = inputArray[j-1];
                    inputArray[j-1] = temp;
                }

                j--;
            }

            i++;
        }

        return inputArray;


    }

    public static int search(int[] inputArray, int element) {
        int start = 0;
        int end = inputArray.length;
        // to prevent overflow in case of very large values
        int mid = start + (end - start)/2;
        boolean found = false;

        while(start <= end) {
            // The element has been found
            if(inputArray[mid] == element) {
                found = true;
                break;
            }

            // Reset the variables
            if(inputArray[mid] >= element) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = start + (end-start)/2;
        }

        // element not found in the array
        if(!found) {
            mid = -1;
        }

        // return the index
        return mid;
    }

    public static String concatenateStringsWithoutDigits(String[] strings) {
        StringBuilder sb = new StringBuilder("");
        Arrays.stream(strings).
                forEach(s -> {
                    s.chars().forEach(c -> {
                        if (c > '9' || c < '0') {
                            sb.append((char) c);
                        }
                    });
                });

        return sb.toString();
    }
}
