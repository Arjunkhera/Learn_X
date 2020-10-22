package com.arjun.exceptions;

import java.util.HashSet;
import java.util.Set;

public class first {
    private static second secondClass = new second();

    public static void main(String[] args) {

        String localProductName = "testProduct";
        String localHoName = "testHO";
        String localPath = "testPath";

        // String test = String.format("\n{\n\tProduct: %s,\nHO: %s,\nPath: %s,\n}\n", localProductName, localHoName, localPath);
        // System.out.println(test);
        // reference();
        setTesting();
    }

    public static void reference() {
        System.out.println("Inside Main()");

        try {
            System.out.println("Inside the try catch block");
            secondClass.parentFunction();
        } catch (Exception e) {
            System.out.println("This was an exception all along");
        }
    }

    public static void setTesting() {
        String assetPath = "testPath";
        Set<String> failedAssets = new HashSet<>();

        try {
            System.out.println("In here");
            if (failedAssets.isEmpty()) {
                System.out.println("Empty Adding Failed Asset: " + assetPath);
                failedAssets.add(assetPath);
            } else if (!failedAssets.contains(assetPath)) {
                System.out.println("Adding Failed Asset: " + assetPath);
                failedAssets.add(assetPath);
            }
        } catch (Exception exception) {
            System.out.println("Error");
        }

        System.out.println("The contents of failed asset are: " + failedAssets);
    }

}
